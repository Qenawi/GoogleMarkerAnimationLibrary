package tjw.go_plus_meeting.ui.feat_map

import android.annotation.SuppressLint
import android.location.Location
import android.location.LocationManager
import android.os.Looper
import com.google.android.gms.location.*
import tjw.go_plus_meeting.domain.base.Either
import tjw.go_plus_meeting.domain.network.Failure
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

enum class LocationTrackState { GpsIsOff, NotHighAccuracy, UnKnown, AllGood }

//todo Clean up code
@Singleton
@SuppressLint("MissingPermission")
class LocationManger @Inject constructor(
    private val location_manger: LocationManager,
    private val fused_client: FusedLocationProviderClient
) : LocationCallback() {
    var l: LocationCallback? = null
    fun getLocation(onResult: (Either<Failure, Location>) -> Unit = {}) {
        when (validateBeforeBulling()) {
            LocationTrackState.GpsIsOff -> onResult(Either.Left(Failure.GPSError))
            LocationTrackState.NotHighAccuracy -> onResult(Either.Left(Failure.GPSError))
            LocationTrackState.UnKnown -> onResult(Either.Left(Failure.GPSError))
            LocationTrackState.AllGood -> mGetLocationFussed(this, onResult)
        }
    }

    private fun validateBeforeBulling(): LocationTrackState = try {
        if (!location_manger.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            LocationTrackState.NotHighAccuracy
        } else if (!location_manger.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {

            LocationTrackState.NotHighAccuracy
        } else {
            LocationTrackState.AllGood
        }
    } catch (e: Exception) {
        LocationTrackState.UnKnown
    }

    private fun stopLocationUpdate(l: LocationCallback) =
        try {
            fused_client.removeLocationUpdates(l)
        } catch (e: Exception) {

        }


    fun clean() {
        l?.let { ll -> stopLocationUpdate(ll) }
    }

    private fun mGetLocationFussed(
        locationManger: LocationManger,
        onResult: (Either<Failure, Location>) -> Unit = {}
    ) {
        l = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult?) {
                p0?.let { location ->
                    //locationManger.stopLocationUpdate(this)
                    onResult(Either.Right(location.lastLocation))
                }
            }
        }
        val locationRequest = LocationRequest.create()?.apply {
            interval = 1000
            fastestInterval = 500
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        locationManger.fused_client.requestLocationUpdates(
            locationRequest,
            l,
            Looper.getMainLooper()
        )
    }
}
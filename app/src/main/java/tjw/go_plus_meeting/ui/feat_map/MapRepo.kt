package com.goplus.goplus_representative.operation_features.home.maps_fragment

import android.graphics.Color
import android.location.Location
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*
import timber.log.Timber
import tjw.go_plus_meeting.domain.base.Either
import tjw.go_plus_meeting.domain.network.Failure
import tjw.go_plus_meeting.domain.network.setArgs
import javax.inject.Inject

interface MapRepo {
    fun addMarker(params: MapUseCase.Params, map: GoogleMap): Either<Failure, Boolean>
    fun drawRadius(map: GoogleMap)
    fun animateCameraToPos(map: GoogleMap?)
    class LocalMap @Inject constructor() : MapRepo {
        private var userLocation: Marker? = null
        private var userCircle: Circle? = null
        override fun addMarker(
            params: MapUseCase.Params,
            map: GoogleMap
        ): Either<Failure, Boolean> {
            return try {
                val i = params.pins
                userLocation = userLocation?.let { marker ->
                    marker.position = LatLng(i.latitude, i.longitude)
                    marker
                } ?: map.addMarker(
                    MarkerOptions().position(
                        LatLng(
                            i.latitude,
                            i.longitude
                        )
                    )
                )
                drawRadius(map) //draw radius
                animateCameraToPos(map)
                return Either.Right(true)
               }catch (e: Exception) {
                Either.Left(Failure.SecurityError.setArgs(e.localizedMessage, e))
              }
              }
        override fun animateCameraToPos(map: GoogleMap?)
        {
            userLocation?.position?.  let {ll->
                map?.moveCamera(
                    CameraUpdateFactory.newLatLngZoom(
                        ll
                        , 16f
                    )
                )
            }

        }
        override fun drawRadius(map: GoogleMap) {
            try {
                userLocation?.position?.let { ll ->
                    userCircle = userCircle?.let { cc ->
                        cc.center = ll
                        cc
                    } ?: map.addCircle(
                        CircleOptions()
                            .center(ll)
                            .radius(300.0)
                            .strokeColor(Color.parseColor("#ff9800"))
                            .strokeWidth(5f)
                            .visible(true)
                            .fillColor(Color.parseColor("#4D212F3C"))
                    )
                }
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}
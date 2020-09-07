package com.goplus.goplus_representative.operation_features.home.maps_fragment

import android.location.Location
import android.location.LocationManager
import android.location.LocationProvider
import com.google.android.gms.maps.GoogleMap
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tjw.go_plus_meeting.domain.base.BaseUseCase
import tjw.go_plus_meeting.domain.base.Either
import tjw.go_plus_meeting.domain.network.Failure
import tjw.go_plus_meeting.ui.feat_map.LocationManger
import javax.inject.Inject

class MapUseCase @Inject constructor
    (
    val repo: MapRepo,
    val scope: CoroutineScope,
    val dispatcher: CoroutineDispatcher,
    val locationManager: LocationManger
) :
    BaseUseCase<Any, Any>(scope, dispatcher)
{

    fun animateCamera(map: GoogleMap?)
    {
      repo.animateCameraToPos(map)
    }
    fun getUserLocation(onRes: (Either<Failure, Location>) -> Unit = {}) {
        locationManager.getLocation(onRes)
    }
    fun populateMap(
        params: Params,
        map: GoogleMap,
        onRes: (Either<Failure, Boolean>) -> Unit = {}
    ) {
        val pins = repo.addMarker(params, map)
        onRes(pins)
    }



    class Params(val pins: Location)
}
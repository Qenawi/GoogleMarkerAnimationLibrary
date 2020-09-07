package com.goplus.goplus_representative.operation_features.home.maps_fragment

import android.app.Application
import android.location.Location
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.maps.GoogleMap
import tjw.go_plus_meeting.domain.base.BaseViewModel
import tjw.go_plus_meeting.domain.network.Failure
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MapViewModel @Inject constructor(app: Application, val useCase: MapUseCase) :
    BaseViewModel<MapUseCase>(app, useCase) {
    var mloading = MutableLiveData<Boolean>()
    var locationResult = MutableLiveData<Location>()
    val obsDeviceId: ObservableField<String> = ObservableField()
    val obsCords: ObservableField<String> = ObservableField()
    val obsDateTime: ObservableField<String> = ObservableField()
    fun populateMap(map: GoogleMap, location: Location) {
        val params = MapUseCase.Params(location)
        mloading.value = true
        useCase.populateMap(params, map) {
            it.either(::handleFailure, ::handlePopulationResult)
        }
    }

    fun pullLocation() {
        mloading.postValue(true)
        useCase.getUserLocation { aa ->
            aa.either(::onAreaFail, ::handleLocationSuccess)
        }
    }

    fun animateMarker(map: GoogleMap?) {
        useCase.animateCamera(map)
    }

    private fun handleLocationSuccess(l: Location) {
        mloading.postValue(false)
        locationResult.postValue(l)
        obsDeviceId.set("getAndroidID(app())")
        obsCords.set(l.latitude.toString() + " lat - " + l.longitude.toString()+" lng")
        val sdf = SimpleDateFormat("dd/MM/yyyy 'at' h:mm a", Locale.ENGLISH)
        obsDateTime.set(sdf.format(Calendar.getInstance().time))
    }

    private fun handlePopulationResult(boolean: Boolean) {
        mloading.value = false
    }


    private fun onAreaFail(f: Failure) {
        mloading.postValue(false)
        toastMutable.postValue(f)

    }
}
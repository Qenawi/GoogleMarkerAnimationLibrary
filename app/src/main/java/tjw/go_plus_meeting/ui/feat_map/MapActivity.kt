package tjw.go_plus_meeting.ui.feat_map

import android.app.AppComponentFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import tjw.go_plus_meeting.R
import tjw.go_plus_meeting.domain.base.BaseActivity
import tjw.go_plus_meeting.extentions.observe

class MapActivity : AppCompatActivity(), OnMapReadyCallback
{

    private var mMap: GoogleMap? = null
    override fun onMapReady(p0: GoogleMap?) {
        p0?.let { map ->
            mMap = map
            map.setMinZoomPreference(5f)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    private fun onViewCreated() {
        val frag = supportFragmentManager.findFragmentById(R.id.l_map_fragment) as SupportMapFragment
        frag.getMapAsync(this)
    }
    }
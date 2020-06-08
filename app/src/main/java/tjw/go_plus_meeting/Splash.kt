package tjw.go_plus_meeting

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import tjw.go_plus_meeting.extentions.delay250
import tjw.go_plus_meeting.extentions.mLaunchActivity
import tjw.link_task.extentions.delay250
import tjw.link_task.extentions.mLaunchActivity

class Splash:AppCompatActivity (){
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_view)
        delay250{
          navigate()
        }
    }
   private fun navigate(){
       mLaunchActivity<MainActivity>(contex = this)
       finish()
   }
}
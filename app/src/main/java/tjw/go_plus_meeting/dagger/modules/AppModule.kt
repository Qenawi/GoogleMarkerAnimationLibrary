package tjw.go_plus_meeting.dagger

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import tjw.go_plus_meeting.R
import javax.inject.Singleton

@Module
class AppModule(val app: Application)
{
    @Singleton
    @Provides
    fun provideAppContext(): Context = app.applicationContext
    @Singleton
    @Provides
    fun provideSharedPrefs(app: Application): SharedPreferences
    {
        return app.getSharedPreferences(app.getString(R.string.AppPrefs_MainKey), 0)
    }
}
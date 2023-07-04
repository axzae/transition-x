package `in`.arunkumarsampath.transitionx.sample

import android.app.Application
import com.hannesdorfmann.adapterdelegates3.BuildConfig
import timber.log.Timber

class TransitionSample : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}

package alif.hamza.moquette.ui

import android.os.Bundle
import android.os.Handler
import com.example.computec.eltadreb.ui.base.BaseActivity
import alif.hamza.moquette.R
import alif.hamza.moquette.ui.login.LoginActivity

class SplashScreen : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        setUp()
    }

    override fun setUp() {
        val SPLASH_DISPLAY_LENGTH = 2000

        Handler().postDelayed({
            loginToApp()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }

    private fun loginToApp() {
        startActivity(LoginActivity.getStartIntent(this))
        finish()
    }

}

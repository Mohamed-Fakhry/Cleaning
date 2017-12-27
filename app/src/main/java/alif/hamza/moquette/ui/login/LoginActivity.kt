package alif.hamza.moquette.ui.login

import android.content.Intent
import android.os.Bundle
import com.example.computec.eltadreb.ui.base.BaseActivity
import alif.hamza.moquette.R
import alif.hamza.moquette.service.LoginPref
import alif.hamza.moquette.ui.map.MapsActivity
import alif.hamza.moquette.ui.signup.SignupActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginContract.View {

    private var loginPresenter: LoginContract.Presenter<LoginActivity>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setUp()
        loginPresenter = LoginPresenter()
        loginPresenter?.onAttach(this);
    }

    private fun goToSignup() {
        val i = Intent(this@LoginActivity, SignupActivity::class.java)
        startActivity(i)
        finish()
    }

    private fun Login() {
        val name = usernameET!!.text.toString()
        val pass = passwordET!!.text.toString()
        loginPresenter!!.validateLoginInfo(name, pass)
    }

    override fun onSuccess(token: String) {
        val loginPref = LoginPref(this)
        loginPref.setAccessToken(this, token)

        val mapIntent = Intent(this@LoginActivity, MapsActivity::class.java)
        startActivity(mapIntent)
        finish()
    }

    override fun setUp() {
        loginBTN.setOnClickListener{
            Login()
        }
        registerTV.setOnClickListener {
            goToSignup()
        }
    }

    companion object {

        fun getStartIntent(baseActivity: BaseActivity): Intent? {
            return Intent(baseActivity, LoginActivity::class.java)
        }
    }
}

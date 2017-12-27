package alif.hamza.moquette.service

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import alif.hamza.moquette.App

class LoginPref(context: Context) {

    private var prefs: SharedPreferences? = null
    var accessToken: String? = null

    init {
        try {
            prefs = context.applicationContext.getSharedPreferences(LOGIN_PREF, Context.MODE_PRIVATE)
            accessToken = prefs!!.getString(KEY_ACCESS_TOKEN, null)
        } catch (e: Exception) { }
    }

    fun setAccessToken(context: Context, accessToken: String) {
        try {
            if (!TextUtils.isEmpty(accessToken)) {
                this.accessToken = accessToken
                prefs!!.edit().putString(KEY_ACCESS_TOKEN, accessToken).apply()
                setSecureConnection()
            }
        } catch (e: Exception) { }
    }

    fun removeAccessToken(context: Context) {
        try {
            this.accessToken = null
            prefs!!.edit().putString(KEY_ACCESS_TOKEN, null).apply()
            removeSecureConnection()
        } catch (e: Exception) { }
    }

    fun setSecureConnection() {
        try {
            App.createApi(AuthInterceptor(this.accessToken))
        } catch (e: Exception) { }
    }

    private fun removeSecureConnection() {
        App.createApi(null)
    }

    companion object {
        private val KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN"
        private val LOGIN_PREF = "LOGIN_PREF"
    }
}

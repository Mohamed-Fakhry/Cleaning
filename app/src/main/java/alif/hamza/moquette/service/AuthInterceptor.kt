package alif.hamza.moquette.service

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthInterceptor(private val accessToken: String?) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val request = original.newBuilder()
                .header("x-access-token", this.accessToken!!)
                .method(original.method(), original.body())
                .build()

        return chain.proceed(request)
    }
}

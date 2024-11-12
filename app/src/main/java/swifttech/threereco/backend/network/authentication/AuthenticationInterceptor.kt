package swifttech.threereco.backend.network.authentication

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response
import java.io.IOException


class AuthenticationInterceptor(private val token: String?) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        val originalRequest = chain.request()

        // Add the JWT token to the request headers
        val requestWithAuthBuilder = originalRequest.newBuilder()

        if (token != null) {
            val requestWithAuth = requestWithAuthBuilder
                .header("Authorization", "Bearer $token")
                .build()

            return chain.proceed(requestWithAuth)
        }

        val requestWithNoAuth = requestWithAuthBuilder.build()

        return chain.proceed(requestWithNoAuth)
    }
}
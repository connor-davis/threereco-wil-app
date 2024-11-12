package swifttech.threereco.backend.network

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import swifttech.threereco.backend.network.authentication.AuthenticationInterceptor
import java.util.concurrent.TimeUnit


const val API_URL = "https://threereco-wil.lone-wolf.dev"

class ApiClient {
    companion object {
        private var retrofit: Retrofit? = null

        fun getClient(context: Context): Retrofit {
            val preferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            val token = preferences.getString("jwt_token", null)

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val authenticationInterceptor = AuthenticationInterceptor(token = token)

            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(authenticationInterceptor)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            if (retrofit == null) {
                retrofit =
                    Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(okHttpClient)
                        .addConverterFactory(
                            GsonConverterFactory.create(gson)
                        )
                        .build()
            }

            return retrofit!!
        }
    }
}
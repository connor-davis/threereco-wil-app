package swifttech.threereco.backend.network.interfaces

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import swifttech.threereco.backend.data.User
import swifttech.threereco.backend.data.UserAuthentication
import swifttech.threereco.backend.data.UserAuthenticationResponse

interface IUser {
    @POST("/Authentication/Register")
    fun register(@Body body: UserAuthentication): Call<UserAuthenticationResponse>

    @POST("/Authentication/Login")
    fun login(@Body body: UserAuthentication): Call<UserAuthenticationResponse>

    @GET("/Authentication/Me")
    fun me(): Call<User>
}
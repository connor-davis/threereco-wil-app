package swifttech.threereco.backend.network.interfaces

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import swifttech.threereco.backend.data.Business
import java.util.UUID

interface IBusiness {
    @GET("/Businesses")
    fun get(
        @Query(value = "includeUser") includeUser: Boolean = false
    ): Call<List<Business>>

    @GET("/Businesses/{id}")
    fun get(
        @Path(value = "id") id: UUID,
        @Query(value = "includeUser") includeUser: Boolean = false
    ): Call<Business>

    @POST("/Businesses")
    fun create(
        @Body business: Business
    ): Call<Business>

    @PUT("/Businesses/{id}")
    fun update(
        @Path(value = "id") id: UUID,
        @Body business: Business
    ): Call<Any>

    @DELETE("/Businesses/{id}")
    fun delete(
        @Path(value = "id") id: UUID
    ): Call<Any>
}
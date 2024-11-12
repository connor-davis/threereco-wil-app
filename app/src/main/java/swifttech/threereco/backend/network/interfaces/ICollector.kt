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
import swifttech.threereco.backend.data.Collector
import java.util.UUID

interface ICollector {
    @GET("/Collectors")
    fun get(
        @Query(value = "includeUser") includeUser: Boolean = false
    ): Call<List<Collector>>

    @GET("/Collectors/{id}")
    fun get(
        @Path(value = "id") id: UUID,
        @Query(value = "includeUser") includeUser: Boolean = false
    ): Call<Collector>

    @POST("/Collectors")
    fun create(
        @Body collector: Collector
    ): Call<Collector>

    @PUT("/Collectors/{id}")
    fun update(
        @Path(value = "id") id: UUID,
        @Body collector: Collector
    ): Call<Any>

    @DELETE("/Collectors/{id}")
    fun delete(
        @Path(value = "id") id: UUID
    ): Call<Any>
}
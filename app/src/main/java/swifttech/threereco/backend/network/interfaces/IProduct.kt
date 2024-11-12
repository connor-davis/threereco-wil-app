package swifttech.threereco.backend.network.interfaces

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import swifttech.threereco.backend.data.Collector
import swifttech.threereco.backend.data.Product
import java.util.UUID

interface IProduct {
    @GET("/Products")
    fun get(
        @Query(value = "includeBusiness") includeBusiness: Boolean = false
    ): Call<List<Product>>

    @GET("/Products/{id}")
    fun get(
        @Path(value = "id") id: UUID,
        @Query(value = "includeBusiness") includeBusiness: Boolean = false
    ): Call<Product>

    @POST("/Products")
    fun create(
        @Body product: Product
    ): Call<Product>

    @PUT("/Products/{id}")
    fun update(
        @Path(value = "id") id: UUID,
        @Body product: Product
    ): Call<Any>

    @DELETE("/Products/{id}")
    fun delete(
        @Path(value = "id") id: UUID
    ): Call<Any>
}
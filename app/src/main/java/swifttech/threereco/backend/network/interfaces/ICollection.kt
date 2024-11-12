package swifttech.threereco.backend.network.interfaces

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import swifttech.threereco.backend.data.Collection
import java.util.UUID

interface ICollection {
    @GET("/Collections")
    fun get(
        @Query(value = "includeBusiness") includeBusiness: Boolean = false,
        @Query(value = "includeCollector") includeCollector: Boolean = false,
        @Query(value = "includeProduct") includeProduct: Boolean = false
    ): Call<List<Collection>>

    @GET("/Collections/{id}")
    fun get(
        @Path(value = "id") id: UUID,
        @Query(value = "includeBusiness") includeBusiness: Boolean = false,
        @Query(value = "includeCollector") includeCollector: Boolean = false,
        @Query(value = "includeProduct") includeProduct: Boolean = false
    ): Call<Collection>

    @POST("/Collections")
    fun create(
        @Body collection: Collection
    ): Call<Collection>

    @PUT("/Collections/{id}")
    fun update(
        @Path(value = "id") id: UUID,
        @Body collection: Collection
    ): Call<Any>

    @DELETE("/Collections/{id}")
    fun delete(
        @Path(value = "id") id: UUID
    ): Call<Any>
}
package ro.marc.pago.data.service

import retrofit2.http.GET
import retrofit2.http.Path
import ro.marc.pago.data.dto.Contact
import ro.marc.pago.data.dto.Post

interface Service {

    @GET("users")
    suspend fun getContacts(): List<Contact>

    @GET("users/{id}/posts")
    suspend fun getPosts(@Path("id") id: Long): List<Post>

}

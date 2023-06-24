package ro.marc.pago.data.service

import retrofit2.http.GET
import ro.marc.pago.data.dto.Contact

interface Service {

    @GET("users")
    suspend fun getContacts(): List<Contact>

}
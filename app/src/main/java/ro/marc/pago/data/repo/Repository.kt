package ro.marc.pago.data.repo

import kotlinx.coroutines.flow.flow
import ro.marc.pago.data.service.Service

class Repository(
    private val service: Service,
) {

    fun getContacts() = flow {
        emit(
            service.getContacts()
                .filter {
                    it.status != "inactive"
                }
        )
    }

    fun getPosts(id: Long) = flow {
        emit(service.getPosts(id))
    }

}

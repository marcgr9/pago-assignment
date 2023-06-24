package ro.marc.pago.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ro.marc.pago.data.dto.Contact
import ro.marc.pago.data.dto.Post
import ro.marc.pago.data.repo.Repository

class MainActivityVM(
    private val repository: Repository,
): ViewModel() {

    private var _contacts: MutableLiveData<List<Contact>> = MutableLiveData(mutableListOf())
    val contacts: LiveData<List<Contact>>
        get() = _contacts

    private var _selectedContact: MutableLiveData<Contact?> = MutableLiveData(null)
    val selectedContact: MutableLiveData<Contact?>
        get() = _selectedContact

    private var _posts: MutableLiveData<List<Post>> = MutableLiveData(mutableListOf())
    val posts: LiveData<List<Post>>
        get() = _posts

    fun getContacts() {
        _contacts.value = listOf()

        viewModelScope.launch {
            repository
                .getContacts()
                .collect {
                    _contacts.value = it
                }
        }
    }

    fun getPosts() {
        _posts.value = listOf()

        viewModelScope.launch {
            repository
                .getPosts(selectedContact.value!!.id)
                .collect {
                    _posts.value = it
                }
        }
    }

}

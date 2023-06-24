package ro.marc.pago.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ro.marc.pago.data.dto.Contact
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

    fun getContacts() {
        viewModelScope.launch {
            repository
                .getContacts()
                .collect {
                    _contacts.value = it
                }
        }
    }

}

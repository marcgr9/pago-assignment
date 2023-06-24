package ro.marc.pago.activity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ro.marc.pago.activity.MainActivity
import ro.marc.pago.activity.adapter.ContactsAdapter
import ro.marc.pago.databinding.FragMainHomeBinding

class MainHome: Fragment() {

    private lateinit var _binding: FragMainHomeBinding
    private val binding
        get() = _binding

    private val activity: MainActivity by lazy {
        requireActivity() as MainActivity
    }

    private val contactsAdapter = ContactsAdapter {
        // activity.navController!!.navigate()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = FragMainHomeBinding.inflate(inflater, null, false)

        activity.configureHeader(null)

        binding.list.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = contactsAdapter
        }

        contactsAdapter.setContacts((1..10).toList())

        return binding.root
    }

}
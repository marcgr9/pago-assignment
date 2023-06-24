package ro.marc.pago.activity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.ObjectKey
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import ro.marc.pago.R
import ro.marc.pago.activity.MainActivity
import ro.marc.pago.activity.MainActivityVM
import ro.marc.pago.activity.adapter.ContactsAdapter
import ro.marc.pago.activity.adapter.PostsAdapter
import ro.marc.pago.databinding.FragMainDetailsBinding
import ro.marc.pago.databinding.FragMainHomeBinding

class MainDetails: Fragment() {

    private lateinit var _binding: FragMainDetailsBinding
    private val binding
        get() = _binding

    private val vm: MainActivityVM by sharedViewModel<MainActivityVM>()

    private val activity: MainActivity by lazy {
        requireActivity() as MainActivity
    }

    private val postsAdapter = PostsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = FragMainDetailsBinding.inflate(inflater, null, false)

        activity.configureHeader(activity.getString(R.string.main_details_title))

        vm.selectedContact.observe(viewLifecycleOwner) {
            it!!

            if (it.id % 2 == 0L) {
                Glide.with(binding.thumbnail)
                    .load("https://picsum.photos/200/200")
                    .signature(ObjectKey(it.hashCode()))
                    .circleCrop()
                    .into(binding.thumbnail)
            } else {
                binding.initials.text = it.name
                    .split(" ")
                    .take(2)
                    .map {
                        it.first()
                    }
                    .joinToString(separator = "")
            }

            binding.name.text = it.name
            binding.email.text = it.email
        }

        vm.getPosts()
        vm.posts.observe(viewLifecycleOwner) {
            postsAdapter.setPosts(it)
        }

        binding.list.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = postsAdapter
        }

        return binding.root
    }

}

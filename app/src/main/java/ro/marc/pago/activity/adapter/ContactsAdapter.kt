package ro.marc.pago.activity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.ObjectKey
import ro.marc.pago.R
import ro.marc.pago.data.dto.Contact
import ro.marc.pago.databinding.CompContactBinding

class ContactsAdapter(
    private val onClick: (Contact) -> Unit,
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val contacts: MutableList<Contact> = mutableListOf()

    fun setContacts(newContacts: List<Contact>) {
        contacts.clear()
        contacts.addAll(newContacts)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val compTranItemBinding = CompContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(compTranItemBinding)
    }

    override fun getItemCount() = contacts.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(contacts[position])
        holder.itemView.setOnClickListener {
            onClick(contacts[position])
        }
    }

    private class ViewHolder(private val item: CompContactBinding) : RecyclerView.ViewHolder(item.root) {

        fun bind(contact: Contact) {
            reset()

            if (contact.id % 2 == 0L) {
                Glide.with(item.thumbnail)
                    .load("https://picsum.photos/200/200")
                    .signature(ObjectKey(contact.hashCode()))
                    .circleCrop()
                    .into(item.thumbnail)
            } else {
                item.initials.text = contact.name
                    .split(" ")
                    .take(2)
                    .map {
                        it.first()
                    }
                    .joinToString(separator = "")
            }

            item.name.text = contact.name

        }

        private fun reset() {
            item.thumbnail.setImageResource(R.drawable.frag_main_thumbnail_placeholder)
            item.initials.text = ""
        }

    }

}

package ro.marc.pago.activity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
            item.name.text = contact.name
        }

    }

}

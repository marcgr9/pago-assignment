package ro.marc.pago.activity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ro.marc.pago.databinding.CompContactBinding
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class ContactsAdapter(
    private val onClick: (Int) -> Unit,
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val contacts: MutableList<Int> = mutableListOf()

    fun setContacts(newContacts: List<Int>) {
        println(newContacts.size)
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

        fun bind(contact: Int) {
            item.name.text = "snifv"
        }

    }

}

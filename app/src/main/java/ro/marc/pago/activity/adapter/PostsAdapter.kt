package ro.marc.pago.activity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ro.marc.pago.data.dto.Post
import ro.marc.pago.databinding.CompPostBinding

class PostsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val posts: MutableList<Post> = mutableListOf()

    fun setPosts(newPosts: List<Post>) {
        posts.clear()
        posts.addAll(newPosts)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val compTranItemBinding = CompPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(compTranItemBinding)
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(posts[position])
    }

    private class ViewHolder(private val item: CompPostBinding) : RecyclerView.ViewHolder(item.root) {

        fun bind(post: Post) {
            item.title.text = post.title
            item.body.text = post.body
        }

    }

}

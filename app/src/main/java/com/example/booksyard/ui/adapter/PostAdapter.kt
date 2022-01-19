package com.example.booksyard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booksyard.databinding.RowLayoutBinding
import com.example.booksyard.model.Post

class PostAdapter : RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    var dataList = emptyList<Post>()

    class MyViewHolder(private val binding: RowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
        fun setView(post: Post) {
            binding.postName.text = post.title
            binding.postDesc.text = post.thumbnailUrl
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.setView(currentItem)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    fun setData(postList: List<Post>) {
        this.dataList = postList
        notifyDataSetChanged()
    }

}
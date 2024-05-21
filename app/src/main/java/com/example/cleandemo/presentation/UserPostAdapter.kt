package com.example.cleandemo.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleandemo.R
import com.example.cleandemo.databinding.UserPostAdapterItemBinding
import com.example.cleandemo.domain.model.User

class UserPostAdapter : RecyclerView.Adapter<UserPostAdapter.ViewHolder>() {
    private var userPosts: List<User> = mutableListOf<User>()

    public fun setData(dataList:List<User>){
        this.userPosts = dataList
    }

    class ViewHolder(itemView: UserPostAdapterItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        val binding : UserPostAdapterItemBinding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding  = DataBindingUtil.inflate<UserPostAdapterItemBinding>(LayoutInflater.from(parent.context),
            R.layout.user_post_adapter_item,parent,false)
        return ViewHolder(binding) }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.user = userPosts[position]
    }

    override fun getItemCount(): Int {
       return userPosts.size
    }

}
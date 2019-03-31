package com.example.rxjresttest.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rxjresttest.Model.Post
import com.example.rxjresttest.R
import java.lang.StringBuilder

class PostAdapter(internal var content:Context, internal  var postList: List<Post>)
    :RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostViewHolder {
        val itemView = LayoutInflater.from(p0.context)
            .inflate(R.layout.post_lay, p0, false)
        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, p1: Int) {
        holder.text_author.text=postList[p1].userId.toString()
        holder.text_title.text=postList[p1].title
        holder.text_content.text=StringBuilder(postList[p1].body.substring(0,20)).append("...").toString()

    }
}


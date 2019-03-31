package com.example.rxjresttest.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.post_lay.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{

    val text_author = itemView._text_author
    val text_title = itemView._text_title
    val text_content = itemView._text_content
}
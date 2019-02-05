package com.labs.daphnis.schoolapp.Activity

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.labs.daphnis.schoolapp.R

/**
 * Created by Avjeet on 22-01-2019.
 */
class BlogAdapter(val context : Context?): RecyclerView.Adapter<BlogViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BlogViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_blog,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(vh: BlogViewHolder, position: Int) {

    }
}

class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  //
}

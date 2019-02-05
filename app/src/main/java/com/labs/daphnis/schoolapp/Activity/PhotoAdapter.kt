package com.labs.daphnis.schoolapp.Activity

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.labs.daphnis.schoolapp.R

/**
 * Created by Avjeet on 22-01-2019.
 */
class PhotoAdapter(val context : Context?): RecyclerView.Adapter<PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): PhotoViewHolder {
        val view  = LayoutInflater.from(context).inflate(
                R.layout.item_gallery,
                parent,
                false)

        val displaymetrics = DisplayMetrics()

        (context as Activity).windowManager.defaultDisplay.getMetrics(displaymetrics)

        val width = (parent.width) / 3

        view.layoutParams.width = width


        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(vh: PhotoViewHolder, position: Int) {
       //
    }
}

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  //
}

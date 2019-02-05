package com.labs.daphnis.schoolapp.Activity.AttendanceActivity

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.labs.daphnis.schoolapp.Activity.PhotoGallery.PhotoViewHolder
import com.labs.daphnis.schoolapp.R

/**
 * Created by Avjeet on 22-01-2019.
 */
class AttendanceAdapter(val context : Context?): RecyclerView.Adapter<PhotoViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, position: Int): PhotoViewHolder {
        return PhotoViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_attendance,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(vh: PhotoViewHolder, position: Int) {

    }
}

class AttendanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  //
}

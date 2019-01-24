package com.labs.daphnis.schoolapp.SchoolFees.SchoolLocationDir

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
class SchoolSelectAdapter(val context : Context?): RecyclerView.Adapter<SchoolSelectViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, position: Int): SchoolSelectViewHolder {
//        val displaymetrics = DisplayMetrics()
//        (context as Activity).windowManager.defaultDisplay.getMetrics(displaymetrics)
//        //if you need three fix imageview in width
//        val devicewidth = displaymetrics.widthPixels / 3
//
//        //if you need 4-5-6 anything fix imageview in height
//        val deviceheight = displaymetrics.heightPixels / 4
//
//        holder.image_view.getLayoutParams().width = devicewidth
//
//        //if you need same height as width you can set devicewidth in holder.image_view.getLayoutParams().height
//        holder.image_view.getLayoutParams().height = deviceheight

        val view = LayoutInflater.from(context).inflate(
            R.layout.school_select_card,
            parent,
            false
        )
        val displaymetrics = DisplayMetrics()

        (context as Activity).windowManager.defaultDisplay.getMetrics(displaymetrics)

        val width =  (parent.width-100) / 2

        val height = (parent.height-40) / 3

        view.layoutParams.width = width

        view.layoutParams.height = height

        return SchoolSelectViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 8
    }

    override fun onBindViewHolder(vh: SchoolSelectViewHolder, position: Int) {
      //
    }
}

class SchoolSelectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
   //
}

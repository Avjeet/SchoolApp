package com.labs.daphnis.iviewsmart.Activity.PhotoGallery

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.labs.daphnis.iviewsmart.R
import kotlinx.android.synthetic.main.item_gallery.view.*

/**
 * Created by Avjeet on 22-01-2019.
 */
class PhotoAdapter(val context: Context?) : RecyclerView.Adapter<PhotoViewHolder>() {

    private lateinit var onImageClickListener: OnImageClickListener

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): PhotoViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_gallery,
            parent,
            false
        )

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
        vh.imageView.setOnClickListener {
            onImageClickListener.onClick(vh.imageView.id)
        }
    }

    fun setOnImageClickListener(listener: OnImageClickListener) {
        this.onImageClickListener = listener
    }
}

interface OnImageClickListener {
    fun onClick(imageId: Int)
}

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.gallery_img
}

package com.labs.daphnis.iviewsmart.SchoolFees.SchoolLocationDir

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.labs.daphnis.iviewsmart.R
import kotlinx.android.synthetic.main.school_select_card.view.*


/**
 * Created by Avjeet on 22-01-2019.
 */
class SchoolSelectAdapter(val context: Context?) : RecyclerView.Adapter<SchoolSelectViewHolder>() {

    private lateinit var onCardClickListener: OnCardClickListener


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): SchoolSelectViewHolder {

        val view = LayoutInflater.from(context).inflate(
            R.layout.school_select_card,
            parent,
            false
        )
        val displaymetrics = DisplayMetrics()

        (context as Activity).windowManager.defaultDisplay.getMetrics(displaymetrics)

        val width = (parent.width - 100) / 2

        val height = (parent.height - 40) / 3

        view.layoutParams.width = width

        view.layoutParams.height = height


        return SchoolSelectViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 8
    }

    override fun onBindViewHolder(vh: SchoolSelectViewHolder, position: Int) {
        vh.schoolName.text = "GNPS School"
        vh.cardView.setOnClickListener{
            onCardClickListener.onClick(vh.schoolName.text.toString())
        }
    }

    fun setOnCardClickListener(listener: OnCardClickListener){
        this.onCardClickListener = listener
    }
}

class SchoolSelectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val schoolName = itemView.school_card_name
    val cardView = itemView.school_card
}

interface OnCardClickListener {
    fun onClick(schoolName : String)
}

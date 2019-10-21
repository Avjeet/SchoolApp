package com.labs.daphnis.iviewsmart.SchoolFees

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.labs.daphnis.iviewsmart.R

/**
 * Created by Avjeet on 22-01-2019.
 */
class PromoCodeAdapter(val context : Context?): RecyclerView.Adapter<PromoCodeViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, position: Int): PromoCodeViewHolder {
        return PromoCodeViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_promo_code,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(vh: PromoCodeViewHolder, position: Int) {

    }
}

class PromoCodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  //
}

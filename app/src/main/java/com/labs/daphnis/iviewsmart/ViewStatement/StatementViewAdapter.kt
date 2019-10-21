package com.labs.daphnis.iviewsmart.ViewStatement

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.labs.daphnis.iviewsmart.R
import kotlinx.android.synthetic.main.statement_item_view.view.*

/**
 * Created by Avjeet on 22-01-2019.
 */
class StatementViewAdapter(val context : Context?): RecyclerView.Adapter<StatementViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, position: Int): StatementViewHolder {
        return StatementViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.statement_item_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(vh: StatementViewHolder, position: Int) {
       vh.statementTime.text =  "12:00 PM"
    }
}

class StatementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val statementText = itemView.stmnt_descr_text
    val statementTime: TextView = itemView.stmnt_time
    val statementTrans = itemView.stmnt_trans
}

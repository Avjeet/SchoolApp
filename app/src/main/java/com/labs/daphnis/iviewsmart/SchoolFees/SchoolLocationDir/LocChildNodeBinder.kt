package com.labs.daphnis.iviewsmart.SchoolFees.SchoolLocationDir

import android.view.View
import android.widget.TextView
import com.labs.daphnis.iviewsmart.R
import tellh.com.recyclertreeview_lib.TreeNode
import tellh.com.recyclertreeview_lib.TreeViewBinder

/**
 * Created by Avjeet on 23-01-2019.
 */
class LocChildNodeBinder : TreeViewBinder<LocChildNodeBinder.ViewHolder>() {
    override fun provideViewHolder(itemView: View): ViewHolder {
        return ViewHolder(itemView)
    }

    override fun bindView(holder: ViewHolder, position: Int, node: TreeNode<*>) {
        val locName = node.content as LocChild
        holder.tvName.text = locName.cLocName
    }

    override fun getLayoutId(): Int {
        return R.layout.location_child_item
    }

    inner class ViewHolder(rootView: View) : TreeViewBinder.ViewHolder(rootView) {
        var tvName: TextView = rootView.findViewById(R.id.tv_name)

    }
}
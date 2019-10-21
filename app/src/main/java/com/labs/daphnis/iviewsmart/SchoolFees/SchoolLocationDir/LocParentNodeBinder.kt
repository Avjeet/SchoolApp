package com.labs.daphnis.iviewsmart.SchoolFees.SchoolLocationDir

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.labs.daphnis.iviewsmart.R
import kotlinx.android.synthetic.main.location_parent_item.view.*
import tellh.com.recyclertreeview_lib.TreeNode
import tellh.com.recyclertreeview_lib.TreeViewBinder


/**
 * Created by Your name on 23-01-2019.
 */
/**
 * Created by Avjeet on 23-01-2019.
 */
class LocParentNodeBinder : TreeViewBinder<LocParentNodeBinder.ViewHolder>() {
    override fun provideViewHolder(itemView: View): ViewHolder {
        return ViewHolder(itemView)
    }

    override fun bindView(holder: ViewHolder, position: Int, node: TreeNode<*>) {
        holder.ivArrow.rotation = 0f

        val rotateDegree = if (node.isExpand) 180f else 0f
        holder.ivArrow.rotation = rotateDegree

        val locName = node.content as LocParent
        holder.tvName.text = locName.pLocName

        if (node.isLeaf)
            holder.ivArrow.visibility = View.INVISIBLE
        else
            holder.ivArrow.visibility = View.VISIBLE
    }

    override fun getLayoutId(): Int {
        return R.layout.location_parent_item
    }

    inner class ViewHolder(rootView: View) : TreeViewBinder.ViewHolder(rootView) {
        val ivArrow: ImageView = rootView.iv_arrow
        val tvName: TextView = rootView.tv_name
        val line: View = rootView.line
    }
}
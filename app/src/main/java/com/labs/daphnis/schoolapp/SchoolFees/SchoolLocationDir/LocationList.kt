package com.labs.daphnis.schoolapp.SchoolFees.SchoolLocationDir

import android.opengl.Visibility
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.labs.daphnis.schoolapp.R
import kotlinx.android.synthetic.main.activity_location_list.*
import tellh.com.recyclertreeview_lib.TreeNode
import tellh.com.recyclertreeview_lib.TreeViewAdapter


class LocationList : AppCompatActivity() {

    private lateinit var nodes: List<TreeNode<LocParent>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_list)

        nodes = ArrayList()

        dataInit()


        location_recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = TreeViewAdapter(nodes, arrayListOf(LocChildNodeBinder(), LocParentNodeBinder()))
        location_recycler_view.adapter = adapter


        adapter.setOnTreeNodeListener(object : TreeViewAdapter.OnTreeNodeListener {
            override fun onClick(node: TreeNode<*>?, holder: RecyclerView.ViewHolder?): Boolean {
                if (!(node?.isLeaf)!!) {
                    //Update and toggle the node.
                    onToggle(!node.isExpand, holder)
                }
                return false
            }

            override fun onToggle(isExpand: Boolean, holder: RecyclerView.ViewHolder?) {
                val locParentHolder: LocParentNodeBinder.ViewHolder = holder as LocParentNodeBinder.ViewHolder
                val ivArrow = locParentHolder.ivArrow
                val rotateDegree = if (isExpand) 180f else -180f
                locParentHolder.line.visibility = if(!isExpand) View.VISIBLE else View.INVISIBLE

                ivArrow.animate().rotationBy(rotateDegree)
                    .start()
            }

        })
    }

    private fun dataInit() {
        val parent1 = TreeNode(LocParent("All India"))
        (nodes as ArrayList<TreeNode<LocParent>>).add(parent1)

        for (i in 0 until 3) {
            parent1.addChild(tcn("Delhi"))
        }

        val parent2 = TreeNode(LocParent("Andhra Pradesh"))
        (nodes as ArrayList<TreeNode<LocParent>>).add(parent2)

        for (i in 0 until 3) {
            parent2.addChild(tcn("Dibugrah"))
        }


    }

    private fun tcn(str: String): TreeNode<LocChild> {
        return TreeNode(LocChild(str))
    }
}

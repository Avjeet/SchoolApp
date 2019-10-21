package com.labs.daphnis.iviewsmart.SchoolFees.SchoolLocationDir

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.labs.daphnis.iviewsmart.R
import kotlinx.android.synthetic.main.activity_location_select.*
import tellh.com.recyclertreeview_lib.TreeNode
import tellh.com.recyclertreeview_lib.TreeViewAdapter


class LocationSelect : AppCompatActivity() {

    private lateinit var nodes: List<TreeNode<LocParent>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_select)

        location_recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        dataInit()

        applyLocationAdapter()

    }

    private fun dataInit() {

        nodes = ArrayList()
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

    private fun applyLocationAdapter(){
        val adapter = TreeViewAdapter(nodes, arrayListOf(LocChildNodeBinder(), LocParentNodeBinder()))
        location_recycler_view.adapter = adapter


        adapter.setOnTreeNodeListener(object : TreeViewAdapter.OnTreeNodeListener {
            override fun onClick(node: TreeNode<*>?, holder: RecyclerView.ViewHolder?): Boolean {
                if (!(node?.isLeaf)!!) {
                    //Update and toggle the node.
                    onToggle(!node.isExpand, holder)
                }else{
                    val locationChild = (node.content as LocChild).cLocName
                    val locationParent = (node.parent.content as LocParent).pLocName
                    setResultData("${locationChild}, ${locationParent}")
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

    private fun setResultData(str : String){
        val intent = Intent()
        intent.data = Uri.parse(str)
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}

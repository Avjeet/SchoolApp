package com.labs.daphnis.iviewsmart.SchoolFees.SchoolLocationDir

import com.labs.daphnis.iviewsmart.R
import tellh.com.recyclertreeview_lib.LayoutItemType

data class LocParent(var pLocName: String) : LayoutItemType {

    override fun getLayoutId(): Int {
        return R.layout.location_parent_item
    }
}

data class LocChild(var cLocName: String): LayoutItemType {
    override fun getLayoutId(): Int {
        return R.layout.location_child_item
    }

}
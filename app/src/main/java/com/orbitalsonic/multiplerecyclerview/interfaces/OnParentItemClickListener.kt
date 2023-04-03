package com.orbitalsonic.multiplerecyclerview.interfaces

import com.orbitalsonic.multiplerecyclerview.datamodel.ChildItem
import com.orbitalsonic.multiplerecyclerview.datamodel.ParentItem

interface OnParentItemClickListener {
    fun onParentItemClick(parentItem: ParentItem)
    fun onChildItemClick(childItem: ChildItem)
}
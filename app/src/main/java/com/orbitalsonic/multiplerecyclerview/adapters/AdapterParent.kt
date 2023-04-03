package com.orbitalsonic.multiplerecyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.orbitalsonic.multiplerecyclerview.R
import com.orbitalsonic.multiplerecyclerview.databinding.ItemParentBinding
import com.orbitalsonic.multiplerecyclerview.datamodel.ChildItem
import com.orbitalsonic.multiplerecyclerview.datamodel.ParentItem
import com.orbitalsonic.multiplerecyclerview.interfaces.OnChildItemClickListener
import com.orbitalsonic.multiplerecyclerview.interfaces.OnParentItemClickListener

class AdapterParent : ListAdapter<ParentItem, RecyclerView.ViewHolder>(diffUtilVideos) {

    private var mListener: OnParentItemClickListener? = null

    fun setOnItemClickListener(listener: OnParentItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemParentBinding>(layoutInflater, R.layout.item_parent, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) {
        val currentItem = getItem(pos)
        val binding = (holder as ViewHolder<*>).globalBinding
        if (binding is ItemParentBinding) {
            binding.apply {
                item = currentItem
                itemClick = mListener

                val adapterChild = AdapterChild()
                recyclerviewChild.adapter = adapterChild
                adapterChild.submitList(currentItem.childList)
                adapterChild.setOnItemClickListener(object : OnChildItemClickListener {
                    override fun onChildItemClick(childItem: ChildItem) {
                        mListener?.onChildItemClick(childItem)
                    }
                })
            }
        }
    }

    inner class ViewHolder<T : ViewBinding>(val globalBinding: T) : RecyclerView.ViewHolder(globalBinding.root)

    companion object {
        val diffUtilVideos = object : DiffUtil.ItemCallback<ParentItem>() {
            override fun areItemsTheSame(oldItem: ParentItem, newItem: ParentItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ParentItem, newItem: ParentItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
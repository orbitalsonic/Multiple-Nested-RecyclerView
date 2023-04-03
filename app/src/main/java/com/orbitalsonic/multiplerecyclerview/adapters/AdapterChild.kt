package com.orbitalsonic.multiplerecyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.orbitalsonic.multiplerecyclerview.R
import com.orbitalsonic.multiplerecyclerview.databinding.ItemChildBinding
import com.orbitalsonic.multiplerecyclerview.datamodel.ChildItem
import com.orbitalsonic.multiplerecyclerview.interfaces.OnChildItemClickListener

class AdapterChild : ListAdapter<ChildItem, RecyclerView.ViewHolder>(diffUtilVideos) {

    private var mListener: OnChildItemClickListener? = null

    fun setOnItemClickListener(listener: OnChildItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemChildBinding>(layoutInflater, R.layout.item_child, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) {
        val currentItem = getItem(pos)
        val binding = (holder as ViewHolder<*>).globalBinding
        if (binding is ItemChildBinding) {
            binding.apply {
                item = currentItem
                itemClick = mListener
            }
        }
    }

    inner class ViewHolder<T : ViewBinding>(val globalBinding: T) : RecyclerView.ViewHolder(globalBinding.root)

    companion object {
        val diffUtilVideos = object : DiffUtil.ItemCallback<ChildItem>() {
            override fun areItemsTheSame(oldItem: ChildItem, newItem: ChildItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ChildItem, newItem: ChildItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
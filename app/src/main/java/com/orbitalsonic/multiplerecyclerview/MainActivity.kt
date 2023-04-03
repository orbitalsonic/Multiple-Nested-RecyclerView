package com.orbitalsonic.multiplerecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.orbitalsonic.multiplerecyclerview.adapters.AdapterParent
import com.orbitalsonic.multiplerecyclerview.databinding.ActivityMainBinding
import com.orbitalsonic.multiplerecyclerview.datamodel.ChildItem
import com.orbitalsonic.multiplerecyclerview.datamodel.ParentItem
import com.orbitalsonic.multiplerecyclerview.dataprovider.DpHome
import com.orbitalsonic.multiplerecyclerview.interfaces.OnParentItemClickListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapterParent by lazy { AdapterParent() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.adapter = adapterParent
        adapterParent.setOnItemClickListener(object : OnParentItemClickListener {
            override fun onParentItemClick(parentItem: ParentItem) {
                Toast.makeText(this@MainActivity, parentItem.piHeading, Toast.LENGTH_SHORT).show()
            }

            override fun onChildItemClick(childItem: ChildItem) {
                Toast.makeText(this@MainActivity, childItem.description, Toast.LENGTH_SHORT).show()
            }

        })
        adapterParent.submitList(DpHome().itemList)
    }
}
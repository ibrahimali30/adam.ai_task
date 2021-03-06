package com.ibrahim.adam_task

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.DividerItemDecoration

import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.ibrahim.adam_task.adapter.Adapter
import com.ibrahim.adam_task.adapter.ViewPagerAdapter
import com.ibrahim.adam_task.data.Item
import kotlinx.android.synthetic.main.item.view.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initTabLayoutView()
    }

    private fun initTabLayoutView() {
        viewPager.adapter = ViewPagerAdapter(listOf("",""))
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.setCustomView(R.layout.layout_custom_item)
                    tab.customView?.findViewById<TextView>(R.id.tvTabTitle)?.text = "Decisions  (2)"
                }
                1 -> {
                    tab.setCustomView(R.layout.layout_custom_item)
                    tab.customView?.findViewById<TextView>(R.id.tvTabTitle)?.text = "Actions  (2)"
                }
            }
        }.attach()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = Adapter(listOf<Item>(
                Item(R.drawable.ic_6,"Attendees",14,"#3380BEF2"),
                Item(R.drawable.ic_3,"Agenda",10,"#33FFB434"),
                Item(R.drawable.ic_5,"Preparation",5,"#331FCC79"),
                Item(R.drawable.ic_4,"Files",2,"#337534FF"),
                Item(R.drawable.ic_2,"Discussion",12,"#33FF8282"),
                Item(R.drawable.ic_1,"Activity",1,"#33C00FC3")
            ))
            val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            ContextCompat.getDrawable(context, R.drawable.divider)?.let {
                itemDecorator.setDrawable(it)
            }
            addItemDecoration(itemDecorator)

        }
    }
}

package com.ibrahim.adam_task.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.adam_task.R

class ViewPagerAdapter(val itemsList: List<Any>): RecyclerView.Adapter<ViewPagerAdapter.ItemViewHolder>() {


    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: Any) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return  ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view_pager, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int = itemsList.size

}
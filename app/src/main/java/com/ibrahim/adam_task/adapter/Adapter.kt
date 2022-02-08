package com.ibrahim.adam_task.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.adam_task.R
import com.ibrahim.adam_task.data.Item
import kotlinx.android.synthetic.main.item.view.*

class Adapter(val itemsList: List<Item>): RecyclerView.Adapter<Adapter.ItemViewHolder>() {


    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: Item) {
            view.itemContainer.setBackgroundColor(Color.parseColor(item.hexaColor))
            view.ivIcon.setImageResource(item.iconRes)
            view.tvTitle.text = item.title
            view.tvCount.text = "(${item.count})"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return  ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int = itemsList.size

}
package com.ibrahim.adam_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.DividerItemDecoration

import androidx.core.content.ContextCompat







class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = Adapter(listOf<Item>())
            val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            ContextCompat.getDrawable(context, R.drawable.divider)?.let {
                itemDecorator.setDrawable(
                    it
                )
            }
            addItemDecoration(itemDecorator)

        }
    }
}

data class Item(
    val title: String,
    val count: Int,
    val hexaColor: String
)
class Adapter(val itemsList: List<Item>): RecyclerView.Adapter<Adapter.ItemViewHolder>() {


    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: Item) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return  ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int = 3

}
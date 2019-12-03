package com.medialink.retrokotlin1

import android.content.Context
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.medialink.retrokotlin1.models.SearchItem
import kotlinx.android.synthetic.main.main_item.view.*

class MainAdapter(val context: Context): RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
    var searchList: List<SearchItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.main_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = searchList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item: SearchItem = searchList[position]
        holder.itemView.txt_title.text = item.title
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> holder.itemView.txt_snippet.text = Html.fromHtml(item.snippet, Html.FROM_HTML_MODE_COMPACT)
            else -> holder.itemView.txt_snippet.text = Html.fromHtml(item.snippet)
        }
        holder.itemView.txt_timestamp.text = item.timestamp
    }

    fun setData(searchList: List<SearchItem>) {
        this.searchList = searchList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}
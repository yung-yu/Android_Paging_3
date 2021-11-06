package org.andy.page_3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.andy.page_3.databinding.AdapterListItemBinding

val USER_COMPARATOR = object : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
        // User ID serves as unique ID
        oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
        // Compare full contents (note: Java users should call .equals())
        oldItem == newItem
}


class SecondPageAdapter(val context: Context):PagingDataAdapter<String, SecondPageAdapter.ViewHolder>(USER_COMPARATOR){

    class ViewHolder(val binding:AdapterListItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.also {
            holder.binding.textView.text = it
        }?: kotlin.run {
            holder.binding.textView.text = ""
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AdapterListItemBinding.inflate(LayoutInflater.from(context), parent, false))
    }
}
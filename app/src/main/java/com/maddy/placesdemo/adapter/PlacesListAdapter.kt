package com.maddy.placesdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.maddy.placesdemo.BR
import com.maddy.placesdemo.R
import com.maddy.placesdemo.databinding.ItemPlacesBinding
import com.maddy.placesdemo.model.PlacesData

class PlacesListAdapter(var context: Context, var newsList: List<PlacesData.Address>) :
    RecyclerView.Adapter<PlacesListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: ItemPlacesBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_places, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList.get(position))
    }

    override fun getItemCount(): Int = newsList.size

    class ViewHolder(
        val binding: ItemPlacesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any) {
            binding.setVariable(BR.address, data)
            binding.executePendingBindings()
        }
    }
}
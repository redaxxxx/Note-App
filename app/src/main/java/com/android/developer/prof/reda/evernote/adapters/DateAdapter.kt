package com.android.developer.prof.reda.evernote.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.developer.prof.reda.evernote.databinding.DayItemBinding
import com.android.developer.prof.reda.evernote.models.DayItem

class DateAdapter: ListAdapter<DayItem, DateAdapter.DayViewHolder>(DiffCallback) {

    class DayViewHolder(private val binding: DayItemBinding): ViewHolder(binding.root){
        fun bind(day: DayItem){

        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<DayItem>(){
        override fun areItemsTheSame(oldItem: DayItem, newItem: DayItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DayItem, newItem: DayItem): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        return DayViewHolder(DayItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        val day = getItem(position)
        holder.bind(day)
    }

}
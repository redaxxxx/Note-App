package com.android.developer.prof.reda.evernote.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.developer.prof.reda.evernote.databinding.DayItemBinding
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

class DateAdapter: ListAdapter<LocalDate, DateAdapter.DayViewHolder>(DiffCallback) {

    class DayViewHolder(private val binding: DayItemBinding): ViewHolder(binding.root){
        fun bind(date: LocalDate){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                binding.dayName.text = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
                binding.day.text = date.dayOfMonth.toString()
                binding.monthName.text = date.month.getDisplayName(TextStyle.SHORT, Locale.getDefault())
            }

        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<LocalDate>(){
        override fun areItemsTheSame(oldItem: LocalDate, newItem: LocalDate): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: LocalDate, newItem: LocalDate): Boolean {
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
        val date = getItem(position)
        holder.bind(date)
    }

}
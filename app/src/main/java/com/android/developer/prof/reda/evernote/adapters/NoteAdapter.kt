package com.android.developer.prof.reda.evernote.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.developer.prof.reda.evernote.databinding.NoteItemBinding
import com.android.developer.prof.reda.evernote.models.Note
import java.util.Random

class NoteAdapter: ListAdapter<Note, NoteAdapter.NoteViewHolder>(DiffCallback) {

    private val random: Random = Random()
    private val colors = mutableListOf("#E3E5E5", "#FFD8F4", "#FCFAD9", "#B0E9CA", "#D9E8FC", "#FDE99D")
    inner class NoteViewHolder(private val binding: NoteItemBinding): ViewHolder(binding.root){
        fun bind(note: Note){

            binding.cardView.setCardBackgroundColor(Color.parseColor(colors[random.nextInt(6)]))
            binding.noteTitle.text = note.title
            binding.noteDescription.text = note.content

            itemView.setOnClickListener {
                onClickItem?.invoke(note)
            }
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.idNote == newItem.idNote
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(NoteItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = getItem(position)
        holder.bind(note)
    }

    var onClickItem: ((Note) -> Unit)? = null
}
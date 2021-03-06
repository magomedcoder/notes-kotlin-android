package ru.magomedcoder.notes.ui.fragment.home

import androidx.recyclerview.widget.ListAdapter
import ru.magomedcoder.notes.data.model.Note
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.magomedcoder.notes.databinding.AdapterItemBinding
import ru.magomedcoder.notes.utils.getDateString

class HomeAdapter(
    private var onMoveToDetail: (Note) -> Unit,
) : ListAdapter<Note, HomeAdapter.NoteViewHolder>(DiffCallback) {

    class NoteViewHolder(
        private val binding: AdapterItemBinding,
        private var onMoveToDetail: (Note) -> Unit,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.apply {
                noteItem.setOnClickListener {
                    onMoveToDetail(note)
                }
                title.text = note.title
                content.text = note.content
                createdAt.text = getDateString(note.createdAt)
                noteItem.setCardBackgroundColor(note.color!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(
            AdapterItemBinding.inflate(layoutInflater, parent, false),
            onMoveToDetail
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = getItem(position)
        holder.bind(note)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == oldItem.id
        }
    }

}
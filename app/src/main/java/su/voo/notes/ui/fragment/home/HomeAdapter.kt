package su.voo.notes.ui.fragment.home

import androidx.recyclerview.widget.ListAdapter
import su.voo.notes.data.model.Note
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import su.voo.notes.databinding.AdapterItemBinding
import su.voo.notes.utils.getDateString

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
                date.text = getDateString(note.timestamp)
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
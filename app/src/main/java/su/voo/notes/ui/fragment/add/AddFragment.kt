package su.voo.notes.ui.fragment.add

import su.voo.notes.ui.base.BaseFragment
import su.voo.notes.databinding.FragmentAddBinding
import android.view.View
import android.os.Bundle
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.ViewGroup
import su.voo.notes.data.model.Note
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController
import su.voo.notes.R
import androidx.core.content.ContextCompat
import android.widget.Toast

@AndroidEntryPoint
class AddFragment : BaseFragment<FragmentAddBinding>() {

    private val viewModel: AddViewModel by viewModels()
    private val navigationArgs: AddFragmentArgs by navArgs()
    private lateinit var note: Note

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = navigationArgs.id
        if (id > 0) {
            viewModel.getOneNote(id).observe(this.viewLifecycleOwner) { selectedNote ->
                note = selectedNote
                bindUpdate(note)
            }
        } else {
            binding.btnAddNote.setOnClickListener {
                insertNote()
            }
        }
        binding.btnGoBack.setOnClickListener {
            findNavController().navigate(R.id.action_add_edit_to_home)
        }
    }

    private fun insertNote() {
        viewModel.insertNote(
            Note(
                title = binding.edTitle.text.toString(),
                content = binding.edContent.text.toString(),
                color = ContextCompat.getColor(
                    requireActivity(),
                    Note.colors.random()
                )
            )
        )
        findNavController().navigate(R.id.action_add_edit_to_home)
        Toast.makeText(activity, "Заметка сохранена", Toast.LENGTH_LONG).show()
    }

    private fun bindUpdate(note: Note) {
        binding.apply {
            edTitle.setText(note.title)
            edContent.setText(note.content)
            btnAddNote.setOnClickListener {
                updateNote(note)
            }
        }
    }

    private fun updateNote(note: Note) {
        viewModel.updateNote(
            Note(
                id = navigationArgs.id,
                title = binding.edTitle.text.toString(),
                content = binding.edContent.text.toString(),
                color = note.color
            )
        )
        findNavController().navigate(R.id.action_add_edit_to_home)
        Toast.makeText(activity, "Заметка изменена", Toast.LENGTH_LONG).show()
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAddBinding.inflate(inflater, container, false)

}
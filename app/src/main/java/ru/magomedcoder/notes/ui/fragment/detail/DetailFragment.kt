package ru.magomedcoder.notes.ui.fragment.detail

import android.annotation.SuppressLint
import ru.magomedcoder.notes.ui.base.BaseFragment
import ru.magomedcoder.notes.databinding.FragmentDetailBinding
import android.view.View
import android.os.Bundle
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.magomedcoder.notes.data.model.Note
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController
import ru.magomedcoder.notes.R
import android.widget.Toast
import androidx.core.view.isVisible
import ru.magomedcoder.notes.utils.getDateString

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private val navigationArgs: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var note: Note

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = navigationArgs.id
        viewModel.getOneNote(id).observe(this.viewLifecycleOwner) { selectedNote ->
            note = selectedNote
            binding.apply {
                title.text = note.title
                content.text = note.content
                if (note.updatedAt !== null) {
                    updatedAt.isVisible = true
                    updatedAt.text = "Последние изменения: " + getDateString(note.updatedAt!!)
                } else {
                    updatedAt.isVisible = false
                }
                btnDelete.setOnClickListener {
                    viewModel.deleteNote(note)
                    findNavController().navigate(R.id.action_detail_to_home)
                    Toast.makeText(activity, "Заметка удалена", Toast.LENGTH_LONG).show()
                }
            }
        }
        binding.btnEdit.setOnClickListener {
            val action = DetailFragmentDirections
                .actionDetailToAddEdit(note.id!!)
            findNavController().navigate(action)
        }
        binding.btnGoBack.setOnClickListener {
            findNavController().navigate(R.id.action_detail_to_home)
        }
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDetailBinding.inflate(inflater, container, false)

}
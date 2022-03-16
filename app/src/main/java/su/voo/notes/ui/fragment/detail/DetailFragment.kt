package su.voo.notes.ui.fragment.detail

import su.voo.notes.ui.base.BaseFragment
import su.voo.notes.databinding.FragmentDetailBinding
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

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private val navigationArgs: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var note: Note

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = navigationArgs.id
        viewModel.getOneNote(id).observe(this.viewLifecycleOwner) { selectedNote ->
            note = selectedNote
            binding.apply {
                title.text = note.title
                content.text = note.content
                btnDelete.setOnClickListener {
                    viewModel.deleteNote(note)
                    findNavController().navigate(R.id.action_detail_to_home)
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
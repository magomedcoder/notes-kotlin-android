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

@AndroidEntryPoint
class AddFragment : BaseFragment<FragmentAddBinding>() {

    private val viewModel: AddViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddNote.setOnClickListener {
            insertNote()
        }
        binding.btnGoBack.setOnClickListener {
            findNavController().navigate(R.id.action_add_edit_to_home)
        }
    }

    private fun insertNote() {
        viewModel.insertNote(
            Note(
                title = binding.edTitle.text.toString(),
                content = binding.edContent.text.toString()
            )
        )
        findNavController().navigate(R.id.action_add_edit_to_home)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAddBinding.inflate(inflater, container, false)

}
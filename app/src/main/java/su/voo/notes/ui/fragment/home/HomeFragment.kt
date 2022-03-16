package su.voo.notes.ui.fragment.home

import su.voo.notes.ui.base.BaseFragment
import su.voo.notes.databinding.FragmentHomeBinding
import android.view.View
import android.os.Bundle
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import su.voo.notes.R
import android.widget.SearchView

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HomeAdapter(
            onMoveToDetail = { note ->
                val action = HomeFragmentDirections.actionHomeToDetail(note.id!!)
                findNavController().navigate(action)
            }
        )
        viewModel.notes.observe(viewLifecycleOwner) { notes ->
            notes?.let {
                adapter.submitList(it)
            }
        }
        binding.apply {
            noteList.adapter = adapter
            addNote.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_addFragment)
            }
            searchNote.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (query != null) {
                        searchDatabase(query)
                    }
                    return true
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    if (query != null) {
                        searchDatabase(query)
                    }
                    return true
                }
            })
        }
    }

    private fun searchDatabase(query: String) {
        val searchQuery = "%$query%"
        viewModel.searchDatabase(searchQuery).observe(this.viewLifecycleOwner) { notes ->
            notes?.let {
                adapter.submitList(it)
            }
        }
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

}
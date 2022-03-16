package su.voo.notes.ui.fragment.home

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import su.voo.notes.domain.AppRepository
import androidx.lifecycle.asLiveData

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    val notes = repository.getAllNotes().asLiveData()

    fun searchDatabase(searchQuery: String) = repository
        .searchDatabase(searchQuery)
        .asLiveData()

}
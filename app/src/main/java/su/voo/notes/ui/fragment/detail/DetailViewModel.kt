package su.voo.notes.ui.fragment.detail

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import su.voo.notes.domain.AppRepository
import androidx.lifecycle.LiveData
import su.voo.notes.data.model.Note
import androidx.lifecycle.asLiveData

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    fun getOneNote(id: Int): LiveData<Note> {
        return repository.getOneNote(id).asLiveData()
    }

}
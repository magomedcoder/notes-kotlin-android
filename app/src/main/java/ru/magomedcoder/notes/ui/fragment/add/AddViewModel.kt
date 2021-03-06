package ru.magomedcoder.notes.ui.fragment.add

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import ru.magomedcoder.notes.domain.AppRepository
import ru.magomedcoder.notes.data.model.Note
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData

@HiltViewModel
class AddViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    fun insertNote(note: Note) {
        viewModelScope.launch {
            repository.insertNote(note)
        }
    }

    fun getOneNote(id: Int): LiveData<Note> {
        return repository.getOneNote(id).asLiveData()
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            repository.updateNote(note)
        }
    }

}
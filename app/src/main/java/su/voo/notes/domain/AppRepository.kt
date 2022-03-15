package su.voo.notes.domain

import kotlinx.coroutines.flow.Flow
import su.voo.notes.data.model.Note

interface AppRepository {

    suspend fun insertNote(note: Note)

    fun getAllNotes(): Flow<List<Note>>

    fun getOneNote(id: Int): Flow<Note>

    suspend fun updateNote(note: Note)

}
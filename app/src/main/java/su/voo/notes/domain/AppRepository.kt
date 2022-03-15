package su.voo.notes.domain

import kotlinx.coroutines.flow.Flow
import su.voo.notes.data.model.Note

interface AppRepository {

    fun getAllNotes(): Flow<List<Note>>

}
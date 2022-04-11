package ru.magomedcoder.notes.domain

import kotlinx.coroutines.flow.Flow
import ru.magomedcoder.notes.data.model.Note

interface AppRepository {

    suspend fun insertNote(note: Note)

    fun getAllNotes(): Flow<List<Note>>

    fun getOneNote(id: Int): Flow<Note>

    suspend fun updateNote(note: Note)

    fun searchDatabase(query: String): Flow<List<Note>>

    suspend fun deleteNote(note: Note)

}
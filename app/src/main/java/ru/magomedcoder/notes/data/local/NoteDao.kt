package ru.magomedcoder.notes.data.local

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.magomedcoder.notes.data.model.Note
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM notes ORDER BY createdAt DESC")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM notes WHERE id =:id")
    fun getOneNote(id: Int): Flow<Note>

    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM notes WHERE title LIKE :query")
    fun searchDatabase(query: String): Flow<List<Note>>

    @Delete
    suspend fun deleteNote(note: Note)

}
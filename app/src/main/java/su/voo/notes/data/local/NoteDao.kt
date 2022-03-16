package su.voo.notes.data.local

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import su.voo.notes.data.model.Note
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM su_voo_note_db ORDER BY timestamp DESC")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM su_voo_note_db WHERE id =:id")
    fun getOneNote(id: Int): Flow<Note>

    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM su_voo_note_db WHERE title LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<Note>>

    @Delete
    suspend fun deleteNote(note: Note)

}
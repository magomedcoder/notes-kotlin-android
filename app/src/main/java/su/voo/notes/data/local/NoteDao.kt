package su.voo.notes.data.local

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import su.voo.notes.data.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM voo_note_db")
    fun getAllNotes(): Flow<List<Note>>

}
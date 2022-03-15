package su.voo.notes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import su.voo.notes.data.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract val dao: NoteDao

}
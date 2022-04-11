package ru.magomedcoder.notes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.magomedcoder.notes.data.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract val dao: NoteDao

}
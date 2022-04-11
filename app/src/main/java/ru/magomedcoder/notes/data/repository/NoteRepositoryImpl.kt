package ru.magomedcoder.notes.data.repository

import ru.magomedcoder.notes.data.local.NoteDao
import ru.magomedcoder.notes.domain.AppRepository
import ru.magomedcoder.notes.data.model.Note

class NoteRepositoryImpl(
    private val dao: NoteDao
) : AppRepository {

    override suspend fun insertNote(note: Note) {
        if (note.title.isEmpty()) {
            dao.insertNote(
                Note(
                    title = "Новая заметка",
                    content = note.content,
                    createdAt = System.currentTimeMillis() / 1000L,
                    color = note.color
                )
            )
        } else {
            dao.insertNote(note)
        }
    }

    override fun getAllNotes() = dao.getAllNotes()

    override fun getOneNote(id: Int) = dao.getOneNote(id)

    override suspend fun updateNote(note: Note) {
        if (note.title.isEmpty()) {
            dao.updateNote(
                Note(
                    title = "Новая заметка",
                    content = note.content,
                    createdAt = note.createdAt,
                    updatedAt = System.currentTimeMillis() / 1000L,
                    color = note.color
                )
            )
        } else {
            dao.updateNote(note)
        }
    }

    override fun searchDatabase(query: String) = dao.searchDatabase(query)

    override suspend fun deleteNote(note: Note) = dao.deleteNote(note)

}
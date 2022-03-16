package su.voo.notes.data.repository

import su.voo.notes.data.local.NoteDao
import su.voo.notes.domain.AppRepository
import su.voo.notes.data.model.Note

class NoteRepositoryImpl(
    private val dao: NoteDao
) : AppRepository {

    override suspend fun insertNote(note: Note) {
        if (note.title.isEmpty()) {
            dao.insertNote(Note(title = "Новая заметка", content = note.content))
        } else {
            dao.insertNote(note)
        }
    }

    override fun getAllNotes() = dao.getAllNotes()

    override fun getOneNote(id: Int) = dao.getOneNote(id)

    override suspend fun updateNote(note: Note) {
        if (note.title.isEmpty()) {
            dao.updateNote(Note(title = "Новая заметка", content = note.content))
        } else {
            dao.updateNote(note)
        }
    }

    override fun searchDatabase(searchQuery: String) = dao.searchDatabase(searchQuery)

    override suspend fun deleteNote(note: Note) = dao.deleteNote(note)

}
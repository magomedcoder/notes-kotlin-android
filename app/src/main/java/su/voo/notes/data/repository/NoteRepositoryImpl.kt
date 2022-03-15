package su.voo.notes.data.repository

import su.voo.notes.data.local.NoteDao
import su.voo.notes.domain.AppRepository

class NoteRepositoryImpl(
    private val dao: NoteDao
) : AppRepository {

    override fun getAllNotes() = dao.getAllNotes()

}
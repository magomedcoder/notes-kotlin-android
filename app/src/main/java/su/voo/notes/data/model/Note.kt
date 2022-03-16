package su.voo.notes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "voo_note_db")
data class Note(
    @PrimaryKey
    val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis() / 1000L
) {
}

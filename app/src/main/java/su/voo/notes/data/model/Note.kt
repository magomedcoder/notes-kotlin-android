package su.voo.notes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import su.voo.notes.R

@Entity(tableName = "voo_note_db")
data class Note(
    @PrimaryKey
    val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis() / 1000L,
    val color: Int? = null,
) {
    companion object {
        val colors = listOf(
            R.color.item_blue,
            R.color.item_red,
            R.color.item_green,
            R.color.item_purple,
            R.color.item_orange,
            R.color.item_alizarin_crimson,
            R.color.item_scarlet,
            R.color.item_amaranth_purple,
        )
    }
}

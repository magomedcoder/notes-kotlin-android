package ru.magomedcoder.notes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.magomedcoder.notes.R

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey
    val id: Int? = null,
    val title: String,
    val content: String,
    val createdAt: Long,
    val updatedAt: Long? = null,
    val color: Int? = null
) {
    companion object {
        val colors = arrayOf(
            R.color.item_red,
            R.color.item_blue,
            R.color.item_green,
            R.color.item_purple,
            R.color.item_orange
        )
    }
}

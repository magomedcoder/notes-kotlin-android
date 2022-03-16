package su.voo.notes.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun getDateString(time: Long): String {

    val simpleDateFormat = SimpleDateFormat("dd MMMM, yyyy")
    return simpleDateFormat.format(time * 1000L)

}
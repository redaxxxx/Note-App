package com.android.developer.prof.reda.evernote.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NotNull
import java.util.Date
import java.util.Locale.Category

@Parcelize
@Entity(tableName = "noteInfo")
data class Note (
    @PrimaryKey
    val idNote: String,
    val title: String,
    val content: String,
    val category: String
): Parcelable{
    constructor(): this("", "", "", "")
}
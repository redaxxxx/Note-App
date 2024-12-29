package com.android.developer.prof.reda.evernote.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.Date

@Entity(tableName = "noteInfo")
data class Note (
    @PrimaryKey(autoGenerate = true)
    @NotNull
    val idNote: Int,
    val title: String,
    val content: String
)
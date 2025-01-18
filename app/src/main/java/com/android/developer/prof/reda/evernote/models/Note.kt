package com.android.developer.prof.reda.evernote.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.Date
import java.util.Locale.Category

enum class Category{ Important, LectureNotes, ToDoList, ShoppingList }

@Entity(tableName = "noteInfo")
data class Note (
    val idNote: String,
    val title: String,
    val content: String,
    val category: String
)
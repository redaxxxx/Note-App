package com.android.developer.prof.reda.evernote.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.android.developer.prof.reda.evernote.models.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: Note)

    @Update
    fun updateNote(note: Note): Int

    @Query("SELECT * FROM noteInfo")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM noteInfo WHERE idNote=:id")
    fun getNoteById(id: Int): LiveData<Note>

    @Query("SELECT * FROM noteInfo WHERE category=:category")
    fun getNotesByCategory(category: String): LiveData<List<Note>>

    @Delete
    fun deleteNote(note: Note)
}
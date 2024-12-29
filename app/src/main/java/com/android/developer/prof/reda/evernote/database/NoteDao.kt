package com.android.developer.prof.reda.evernote.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.developer.prof.reda.evernote.models.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(note: Note)

    @Query("SELECT * FROM noteInfo")
    suspend fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM noteInfo WHERE idNote=:id")
    suspend fun getNoteById(id: Int): LiveData<Note>

    @Delete
    suspend fun deleteNote(note: Note)
}
package com.android.developer.prof.reda.evernote.repositories

import androidx.lifecycle.LiveData
import com.android.developer.prof.reda.evernote.database.NoteDao
import com.android.developer.prof.reda.evernote.models.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insertNote(note: Note){
        return noteDao.insert(note)
    }

    suspend fun updateNote(note: Note): Int{
        return noteDao.updateNote(note)
    }
    suspend fun getAllNotes(){
        noteDao.getAllNotes()
    }

    suspend fun getNoteById(id: Int){
        noteDao.getNoteById(id)
    }

    suspend fun deleteNote(note: Note){
        noteDao.deleteNote(note)
    }

    suspend fun getNotesByCategory(category: String): LiveData<List<Note>>{
       return noteDao.getNotesByCategory(category)
    }
}
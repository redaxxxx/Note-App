package com.android.developer.prof.reda.evernote.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.developer.prof.reda.evernote.models.Note
import com.android.developer.prof.reda.evernote.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
): ViewModel() {

    val allNotes: LiveData<List<Note>> = repository.allNotes
    private lateinit var notesByCategory: LiveData<List<Note>>
    fun insertNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNote(note)
        }
    }

    fun updateNote(note: Note){
        viewModelScope.launch {
            repository.updateNote(note)
        }
    }
    fun delete(note: Note){
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }

    fun getNoteById(id: Int){
        viewModelScope.launch {
            repository.getNoteById(id)
        }
    }

    fun getNotesByCategory(category: String): LiveData<List<Note>>{
        viewModelScope.launch {
            notesByCategory = repository.getNotesByCategory(category)
        }
        return notesByCategory
    }
}
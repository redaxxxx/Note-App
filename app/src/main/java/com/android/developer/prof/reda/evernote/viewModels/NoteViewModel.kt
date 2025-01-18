package com.android.developer.prof.reda.evernote.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.developer.prof.reda.evernote.models.Note
import com.android.developer.prof.reda.evernote.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
): ViewModel() {

    val allNotes: LiveData<List<Note>> = repository.allNotes

    fun upsert(note: Note){
        viewModelScope.launch {
            repository.upsertNote(note)
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
}
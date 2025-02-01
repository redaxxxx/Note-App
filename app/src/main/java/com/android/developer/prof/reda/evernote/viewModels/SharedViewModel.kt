package com.android.developer.prof.reda.evernote.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.developer.prof.reda.evernote.models.Note
import com.android.developer.prof.reda.evernote.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class SharedViewModel: ViewModel() {

    private val _sharedData = MutableLiveData<Note>()
    val sharedData: LiveData<Note>
        get() = _sharedData
    fun setNoteInfo(note: Note){
        viewModelScope.launch {
            _sharedData.value = note
        }
    }
}
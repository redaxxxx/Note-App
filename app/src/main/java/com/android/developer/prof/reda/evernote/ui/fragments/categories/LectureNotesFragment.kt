package com.android.developer.prof.reda.evernote.ui.fragments.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.android.developer.prof.reda.evernote.R
import com.android.developer.prof.reda.evernote.adapters.NoteAdapter
import com.android.developer.prof.reda.evernote.databinding.FragmentImportantBinding
import com.android.developer.prof.reda.evernote.databinding.FragmentLectureNotesBinding
import com.android.developer.prof.reda.evernote.utils.IMPORTANT
import com.android.developer.prof.reda.evernote.utils.LECTURE_NOTES
import com.android.developer.prof.reda.evernote.viewModels.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LectureNotesFragment : Fragment() {
    private lateinit var binding: FragmentLectureNotesBinding
    private val noteViewModel by viewModels<NoteViewModel>()
    private val noteAdapter by lazy { NoteAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_lecture_notes,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getLectureNotes()
    }

    private fun getLectureNotes(){
        noteViewModel.getNotesByCategory(LECTURE_NOTES).observe(viewLifecycleOwner){

            if (it.isEmpty()){
                binding.emptyTv.visibility = View.VISIBLE
            }

            noteAdapter.submitList(it)
            binding.lectureNotesRv.adapter = noteAdapter
        }
    }
}
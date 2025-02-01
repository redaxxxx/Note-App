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
import com.android.developer.prof.reda.evernote.databinding.FragmentToDoListsBinding
import com.android.developer.prof.reda.evernote.utils.IMPORTANT
import com.android.developer.prof.reda.evernote.utils.TODO_LIST
import com.android.developer.prof.reda.evernote.viewModels.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoListsFragment : Fragment() {
    private lateinit var binding: FragmentToDoListsBinding
    private val noteViewModel by viewModels<NoteViewModel>()
    private val noteAdapter by lazy { NoteAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_to_do_lists,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getToDoList()
    }

    private fun getToDoList(){
        noteViewModel.getNotesByCategory(TODO_LIST).observe(viewLifecycleOwner){

            if (it.isEmpty()){
                binding.emptyTv.visibility = View.VISIBLE
            }

            noteAdapter.submitList(it)
            binding.toDoNotesRv.adapter = noteAdapter
        }
    }
}
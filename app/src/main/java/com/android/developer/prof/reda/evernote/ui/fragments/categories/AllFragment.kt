package com.android.developer.prof.reda.evernote.ui.fragments.categories

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.android.developer.prof.reda.evernote.R
import com.android.developer.prof.reda.evernote.adapters.NoteAdapter
import com.android.developer.prof.reda.evernote.databinding.FragmentAllBinding
import com.android.developer.prof.reda.evernote.models.Note
import com.android.developer.prof.reda.evernote.ui.fragments.NotesFragmentDirections
import com.android.developer.prof.reda.evernote.viewModels.NoteViewModel
import com.android.developer.prof.reda.evernote.viewModels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class AllFragment : Fragment() {
    private lateinit var binding: FragmentAllBinding
    private val adapter by lazy { NoteAdapter() }
    private val noteViewModel by viewModels<NoteViewModel>()
//    private val sharedViewModel: SharedViewModel by navGraphViewModels(R.id.home_nav)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_all,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllNotes()

        adapter.onClickItem = {
            findNavController().navigate(NotesFragmentDirections.actionNotesFragmentToAddNewNoteFragment(it))
        }
    }

    private fun getAllNotes(){
        noteViewModel.allNotes.observe(viewLifecycleOwner){

            if (it.isEmpty()){
                binding.emptyTv.visibility = View.VISIBLE
            }else{
                binding.emptyTv.visibility = View.GONE
            }

            adapter.submitList(it)
            binding.allNotesRv.adapter = adapter

        }
    }
}
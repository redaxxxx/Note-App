package com.android.developer.prof.reda.evernote.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.android.developer.prof.reda.evernote.R
import com.android.developer.prof.reda.evernote.databinding.FragmentAddNoteBinding
import com.android.developer.prof.reda.evernote.models.Note
import com.android.developer.prof.reda.evernote.utils.IMPORTANT
import com.android.developer.prof.reda.evernote.utils.LECTURE_NOTES
import com.android.developer.prof.reda.evernote.utils.SHOPPING_LIST
import com.android.developer.prof.reda.evernote.utils.TODO_LIST
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : Fragment() {
    private lateinit var binding: FragmentAddNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_note,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.arrowBackBtn.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.importantLayout.setOnClickListener {
            findNavController().navigate(
                AddNoteFragmentDirections.actionAddNoteFragmentToAddNewNoteFragment(
                    Note("","","",IMPORTANT)
                )
            )
        }

        binding.lectureLayout.setOnClickListener {
            findNavController().navigate(
                AddNoteFragmentDirections.actionAddNoteFragmentToAddNewNoteFragment(
                    Note("","","", LECTURE_NOTES)
                )
            )
        }

        binding.todoLayout.setOnClickListener {
            findNavController().navigate(
                AddNoteFragmentDirections.actionAddNoteFragmentToAddNewNoteFragment(
                    Note("","","", TODO_LIST)
                )
            )
        }

        binding.shoppingLayout.setOnClickListener {
            findNavController().navigate(
                AddNoteFragmentDirections.actionAddNoteFragmentToAddNewNoteFragment(
                    Note("","","", SHOPPING_LIST)
                )
            )
        }
    }

}
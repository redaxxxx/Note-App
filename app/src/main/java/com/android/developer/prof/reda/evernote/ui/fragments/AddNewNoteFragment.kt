package com.android.developer.prof.reda.evernote.ui.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.developer.prof.reda.evernote.R
import com.android.developer.prof.reda.evernote.databinding.FragmentAddNewNoteBinding
import com.android.developer.prof.reda.evernote.models.Note
import com.android.developer.prof.reda.evernote.viewModels.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.Random

@AndroidEntryPoint
class AddNewNoteFragment : Fragment() {
    private lateinit var binding: FragmentAddNewNoteBinding
    private val viewModel by viewModels<NoteViewModel>()
//    private var category: String = ""
    private val CHAR_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
    private val ID_LENGTH = 10
    private var note: Note ?= null
//    private val sharedViewModel: SharedViewModel by navGraphViewModels(R.id.home_nav)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_new_note,
            container,
            false
        )

        note = AddNewNoteFragmentArgs.fromBundle(requireArguments()).note
        Timber.tag("edit: ").d(note.toString())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (note!!.title != ""){
            binding.titleEt.setText(note!!.title)
            binding.contentEt.setText(note!!.content)

            binding.backBtn.setOnClickListener {
                viewModel.updateNote(
                    Note(
                        note!!.idNote,
                        binding.titleEt.text.trim().toString(),
                        binding.contentEt.text.trim().toString(),
                        note!!.category
                    )
                )

                val dialog = AlertDialog.Builder(activity)
                dialog.setNegativeButton("Discard"){_,dialog->
                    findNavController().navigateUp()
                }
                dialog.setPositiveButton("Save"){_,dialog->
                    findNavController().navigate(
                        AddNewNoteFragmentDirections.actionAddNewNoteFragmentToNotesFragment()
                    )
                }
                dialog.create().show()
            }

        }else{
            binding.backBtn.setOnClickListener {

                if (binding.contentEt.text.isNotEmpty() && binding.titleEt.text.isNotEmpty()){

                    viewModel.insertNote(
                        Note(
                            generateUniqueId(),
                            binding.titleEt.text.trim().toString(),
                            binding.contentEt.text.trim().toString(),
                            note!!.category
                        )
                    )
                }
                findNavController().navigate(AddNewNoteFragmentDirections.actionAddNewNoteFragmentToNotesFragment())
            }
        }

        binding.backBtn.setOnClickListener {

            if (binding.contentEt.text.isNotEmpty() && binding.titleEt.text.isNotEmpty()){

                viewModel.insertNote(
                    Note(
                        generateUniqueId(),
                        binding.titleEt.text.trim().toString(),
                        binding.contentEt.text.trim().toString(),
                        note!!.category
                    )
                )
            }
            findNavController().navigate(AddNewNoteFragmentDirections.actionAddNewNoteFragmentToNotesFragment())
        }

    }

    private fun generateUniqueId(): String{
        val sb = StringBuilder()
        val random = Random()

        for (i in 0 until ID_LENGTH) {
            val index = random.nextInt(CHAR_LIST.length)
            sb.append(CHAR_LIST[index])
        }

        return sb.toString()
    }
}
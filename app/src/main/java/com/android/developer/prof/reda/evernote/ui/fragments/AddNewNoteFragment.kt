package com.android.developer.prof.reda.evernote.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.android.developer.prof.reda.evernote.R
import com.android.developer.prof.reda.evernote.databinding.FragmentAddNewNoteBinding
import com.android.developer.prof.reda.evernote.models.Category
import com.android.developer.prof.reda.evernote.models.Note
import com.android.developer.prof.reda.evernote.viewModels.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder
import java.util.Random

@AndroidEntryPoint
class AddNewNoteFragment : Fragment() {
    private lateinit var binding: FragmentAddNewNoteBinding
    private val viewModel by viewModels<NoteViewModel>()
    private var category: String = ""
    private val CHAR_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
    private val ID_LENGTH = 10
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_new_note,
            container,
            false
        )

        category = AddNewNoteFragmentArgs.fromBundle(requireArguments()).category

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBtn.setOnClickListener {

            if (binding.contentEt.text.isNotEmpty()){
                viewModel.upsert(
                    Note(
                        generateUniqueId(),
                        binding.titleEt.text.trim().toString(),
                        binding.contentEt.text.trim().toString(),
                        category
                    )
                )
            }
        }
    }

    private fun generateUniqueId(): String{
        val sb = StringBuilder()
        val random = Random()

        CHAR_LIST.forEach {
            val index = random.nextInt(CHAR_LIST.length)
            sb.append(CHAR_LIST[index])
        }

        return sb.toString()
    }
}
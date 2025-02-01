package com.android.developer.prof.reda.evernote.ui.fragments.categories

import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.android.developer.prof.reda.evernote.R
import com.android.developer.prof.reda.evernote.adapters.NoteAdapter
import com.android.developer.prof.reda.evernote.databinding.FragmentImportantBinding
import com.android.developer.prof.reda.evernote.databinding.FragmentShoppingBinding
import com.android.developer.prof.reda.evernote.utils.LECTURE_NOTES
import com.android.developer.prof.reda.evernote.utils.SHOPPING_LIST
import com.android.developer.prof.reda.evernote.viewModels.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShoppingFragment : Fragment() {

    private lateinit var binding: FragmentShoppingBinding
    private val noteViewModel by viewModels<NoteViewModel>()
    private val noteAdapter by lazy { NoteAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shopping,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getShoppingList()
    }

    private fun getShoppingList(){
        noteViewModel.getNotesByCategory(SHOPPING_LIST).observe(viewLifecycleOwner){
            if (it.isEmpty()){
                binding.emptyTv.visibility = View.VISIBLE
            }
            noteAdapter.submitList(it)
            binding.shoppingNotesRv.adapter = noteAdapter
        }
    }
}
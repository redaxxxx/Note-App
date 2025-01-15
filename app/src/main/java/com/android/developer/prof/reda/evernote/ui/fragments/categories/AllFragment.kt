package com.android.developer.prof.reda.evernote.ui.fragments.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.android.developer.prof.reda.evernote.R
import com.android.developer.prof.reda.evernote.adapters.NoteAdapter
import com.android.developer.prof.reda.evernote.databinding.FragmentAllBinding

class AllFragment : Fragment() {
    private lateinit var binding: FragmentAllBinding
    private val adapter by lazy { NoteAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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

//        adapter.submitList()
//        binding.allNotesRv.adapter = adapter

    }
}
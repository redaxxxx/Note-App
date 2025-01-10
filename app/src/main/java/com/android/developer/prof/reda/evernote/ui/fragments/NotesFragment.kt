package com.android.developer.prof.reda.evernote.ui.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.android.developer.prof.reda.evernote.R
import com.android.developer.prof.reda.evernote.adapters.DateAdapter
import com.android.developer.prof.reda.evernote.adapters.ViewPagerAdapter
import com.android.developer.prof.reda.evernote.databinding.FragmentNotesBinding
import com.android.developer.prof.reda.evernote.ui.fragments.categories.AllFragment
import com.android.developer.prof.reda.evernote.ui.fragments.categories.ImportantFragment
import com.android.developer.prof.reda.evernote.ui.fragments.categories.LectureNotesFragment
import com.android.developer.prof.reda.evernote.ui.fragments.categories.ShoppingFragment
import com.android.developer.prof.reda.evernote.ui.fragments.categories.ToDoListsFragment
import com.google.android.material.tabs.TabLayoutMediator
import java.time.LocalDate

class NotesFragment : Fragment() {

    private lateinit var binding: FragmentNotesBinding
    private val currentMonthDates = mutableListOf<LocalDate>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_notes,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dateAdapter = DateAdapter()
        dateAdapter.submitList(getCurrentDate())
        binding.dateRv.adapter = dateAdapter

        val categoriesFragments = arrayListOf<Fragment>(
            AllFragment(),
            ImportantFragment(),
            LectureNotesFragment(),
            ToDoListsFragment(),
            ShoppingFragment()
        )

        binding.viewPager.isUserInputEnabled = false

        val viewPagerAdapter = ViewPagerAdapter(categoriesFragments, childFragmentManager, lifecycle)

        binding.viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position->
            when(position){
                0-> tab.text = "All"
                1-> tab.text = "Important"
                2-> tab.text = "Lecture notes"
                3-> tab.text = "To-do lists"
                4-> tab.text = "Shopping"
            }
        }.attach()

        for (i in 0 until binding.tabLayout.tabCount) {
            val tab = (binding.tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val layoutParams = tab.layoutParams as ViewGroup.MarginLayoutParams
            layoutParams.setMargins(16, 0, 16, 0)
            tab.layoutParams = layoutParams
        }
    }

    private fun getCurrentDate(): List<LocalDate>{
        val currentMonthDates = mutableListOf<LocalDate>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val currentDate = LocalDate.now()
            val startOfMonth = currentDate.withDayOfMonth(1)
            val endOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth())
            var tempDate = startOfMonth

            while (!tempDate.isAfter(endOfMonth)){
                currentMonthDates.add(tempDate)
                tempDate = tempDate.plusDays(1)
            }
        }

        return currentMonthDates
    }
}
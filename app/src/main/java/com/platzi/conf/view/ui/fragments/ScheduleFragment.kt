package com.platzi.conf.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.platzi.conf.R
import com.platzi.conf.view.adapter.ScheduleAdapter
import com.platzi.conf.viewmodel.ScheduleViewModel

/**
 * A simple [Fragment] subclass.
 */
class ScheduleFragment : Fragment() {

    private lateinit var scheduleAdapter: ScheduleAdapter
    private lateinit var viewModel : ScheduleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated (view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
    }



}

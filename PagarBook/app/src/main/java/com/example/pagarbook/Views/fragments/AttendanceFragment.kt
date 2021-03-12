package com.example.pagarbook.Views.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pagarbook.R
import com.example.pagarbook.Views.Activity.HelpActivity
import kotlinx.android.synthetic.main.fragment_attendance.view.*
import kotlinx.android.synthetic.main.fragment_staff.view.*

class AttendanceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attendance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.iv_help.setOnClickListener {
            startActivity(Intent(context, HelpActivity::class.java))
        }
    }

}
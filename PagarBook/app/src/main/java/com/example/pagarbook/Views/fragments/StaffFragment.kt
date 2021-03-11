package com.example.pagarbook.Views.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pagarbook.R
import com.example.pagarbook.Views.Activity.AddStaffActivity
import com.example.pagarbook.Views.Activity.HelpActivity
import kotlinx.android.synthetic.main.fragment_staff.view.*


class StaffFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_staff, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.tv_staff_count.setOnClickListener {
            startActivity(Intent(context, AddStaffActivity::class.java))
        }

        view.layoutStaffHelp.setOnClickListener {
            startActivity(Intent(context, HelpActivity::class.java))
        }
    }

}
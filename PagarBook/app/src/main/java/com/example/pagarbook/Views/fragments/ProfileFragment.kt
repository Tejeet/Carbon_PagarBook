package com.example.pagarbook.Views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pagarbook.DataNConstants.ConstantsNData
import com.example.pagarbook.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {

    var cn = ConstantsNData()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.tvProfileLogout.setOnClickListener {
            cn.setLoginStatus(context,"0")
            System.exit(1)


        }
    }
}
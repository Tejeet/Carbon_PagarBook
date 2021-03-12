package com.example.pagarbook.Views.fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pagarbook.DataNConstants.ConstantsNData
import com.example.pagarbook.R
import com.example.pagarbook.Views.Activity.EditBusinessNameActivity
import com.example.pagarbook.Views.Activity.EditUserNameActivity
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
            cn.setLoginStatus(context, "0")
            System.exit(1)
        }

        view.tvProfileYourName.text = cn.getUserName(context)
        view.tvProfileBusinessName.text = cn.getBussinessName(context)
        view.tvProfileNumberOfStaff.text = cn.getStaffs(context)

        view.tvEditYourName.setOnClickListener {
            val intent=Intent(context, EditUserNameActivity::class.java)
            var name= cn.getUserName(context)
            intent.putExtra("name", name)
            startActivity(intent)
        }
        view.tvEditBussinessName.setOnClickListener {
            val intent=Intent(context, EditBusinessNameActivity::class.java)
            var business= cn.getBussinessName(context)
            intent.putExtra("business", business)
            intent.putExtra("staff", cn.getStaffs(context))
            startActivity(intent)
        }

        val BottomSheetLanguage=BottomSheetLanguageFragment()
        view.tvChangeLanguage.setOnClickListener {
            BottomSheetLanguage.show(activity!!.supportFragmentManager,"BottomSheetObject")
        }
    }


}
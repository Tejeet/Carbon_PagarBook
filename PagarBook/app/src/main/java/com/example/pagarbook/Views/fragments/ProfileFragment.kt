package com.example.pagarbook.Views.fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.pagarbook.DataNConstants.ConstantsNData
import com.example.pagarbook.R
import com.example.pagarbook.Views.Activity.EditBusinessNameActivity
import com.example.pagarbook.Views.Activity.EditUserNameActivity
import com.example.pagarbook.Views.Activity.HelpActivity
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


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

            val builder = AlertDialog.Builder(activity!!)
            builder.setTitle("Logout")
            builder.setMessage("Are sure wants to logout")

            builder.setPositiveButton("YES", DialogInterface.OnClickListener { dialog, id ->

                cn.setLoginStatus(context, "0")
                System.exit(0)


            })

            builder.setNegativeButton("NO", DialogInterface.OnClickListener {
                    dialog, id ->
                dialog.dismiss()

            })

            builder.setCancelable(true)
            builder.show()


        }

        view.tvProfileLanguage.text = cn.getLanguageKey(context)
        view.tvProfilePhoneNumber.text = cn.getUserMobile(context)
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

        llHelp.setOnClickListener {
            startActivity(Intent(context,HelpActivity::class.java))
        }
    }


}
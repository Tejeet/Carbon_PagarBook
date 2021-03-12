package com.example.pagarbook.Views.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.pagarbook.Models.OTPResponseDTOModel
import com.example.pagarbook.R
import com.example.pagarbook.Repository.PagarBookRepository
import com.example.pagarbook.ViewModel.PagarBookViewModel
import com.example.pagarbook.ViewModel.PagarBookViewModelFactory
import com.example.pagarbook.Views.ApplicationClass.PagarBookApplication
import kotlinx.android.synthetic.main.activity_account_login.*
import kotlinx.android.synthetic.main.activity_add_staff.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class AccountLogin : AppCompatActivity() {

    private val TAG = "tag"

    private lateinit var viewModel : PagarBookViewModel

    lateinit var resp : OTPResponseDTOModel

    var gOTP = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_login)


        val appObj  = application as PagarBookApplication
        val reposotory : PagarBookRepository = appObj.repository

        val viewModelFactory = PagarBookViewModelFactory(reposotory)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PagarBookViewModel::class.java)


        btn_continue_add_staff.setOnClickListener {

            if (EtPhoneNumber.text.toString()
                    .isEmpty() || EtPhoneNumber.text.toString().length > 10
            ) {

                EtPhoneNumber.error = ("Invalid Phone Number")
            } else {

                progressBar.visibility = View.VISIBLE

                btn_continue_add_staff.setBackgroundResource(R.drawable.bluecontinuebt)


                CoroutineScope(Dispatchers.IO).launch {

                    resp = viewModel.getOTP(EtPhoneNumber.text.toString())

                    gOTP = resp.otpIS.toString()

                    Log.d(TAG, "Server side Response is $gOTP")

                    if (resp.success == 1) {

                        Log.d(TAG, "Sending OTP to next page $gOTP")
                        var intent = Intent(this@AccountLogin, SubmitOTP::class.java)
                        intent.putExtra("OTP", gOTP)
                        startActivity(Intent(intent))

                    }

                }

            }
        }

    }



}


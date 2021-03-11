package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.pagarbook.DataNConstants.ConstantsNData
import com.example.pagarbook.R
import kotlinx.android.synthetic.main.activity_submit_o_t_p.*

class SubmitOTP : AppCompatActivity() {


    private val TAG = "tag"

    val cn = ConstantsNData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit_o_t_p)


        val otp = intent.getStringExtra("OTP")

        Log.d(TAG, "Incoming OTP is $otp")

        BtContinueOTP.setOnClickListener {
            if (EtOtpSubmit.text.toString() == otp.toString()) {

                cn.setLoginStatus(this, "1")
                startActivity(Intent(this, DetailsActivity::class.java))

            } else {

                cn.setLoginStatus(this, "0")

                EtOtpSubmit.error = "Wrong OTP"
            }
        }
    }
}

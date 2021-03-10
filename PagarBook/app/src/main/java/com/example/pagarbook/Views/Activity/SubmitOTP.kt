package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.pagarbook.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_account_login.*
import kotlinx.android.synthetic.main.activity_submit_o_t_p.*

class SubmitOTP : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit_o_t_p)
        auth= FirebaseAuth.getInstance()
        var otp=intent.getStringExtra("auth")

        BtContinueOTP.setOnClickListener {
            if(EtOtpSubmit.text.toString().length==6) {
                var verificationId = EtOtpSubmit.text.toString()
                val credential = PhoneAuthProvider.getCredential(otp!!, verificationId)
                signInWithPhoneAuthCredential(credential)
            }else{
                EtOtpSubmit.error="OTP is not 6 Digit"
            }
        }
    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this@SubmitOTP,DetailsActivity::class.java))
                    Log.d("TAG", "signInWithCredential:success")
                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w("TAG", "signInWithCredential:failure", task.exception)
                    Toast.makeText(this,"OTP invalid",Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }

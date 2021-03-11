package com.example.pagarbook.Views.Activity

import android.R.attr.phoneNumber
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.pagarbook.R
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_account_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class AccountLogin : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private var storedVerificationId: String? = ""
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_login)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth
        BtContinueLogin.setOnClickListener {
            if (EtPhoneNumber.text.toString().isEmpty()||EtPhoneNumber.text.toString().length >10 ||
                EtPhoneNumber.text.toString().length < 10 ) {
                EtPhoneNumber.error=("Invalid Phone Number")
            } else {
                progressBar.visibility = View.VISIBLE
                BtContinueLogin.setBackgroundResource(R.drawable.bluecontinuebt)
                verify()
            }
        }
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                Log.d("TAG", "onVerificationCompleted:$credential")
                signInWithPhoneAuthCredential(credential)
                progressBar.visibility = View.INVISIBLE
                BtContinueLogin.setBackgroundResource(R.drawable.bluecontinuebt)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Log.w("TAG", "onVerificationFailed", e)
                Toast.makeText(this@AccountLogin,"Try Again",Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.INVISIBLE
                BtContinueLogin.setBackgroundResource(R.drawable.bluecontinuebt)
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                CoroutineScope(Dispatchers.Default).launch {
                    Thread.sleep(3 * 1000);
                    val intent = Intent(this@AccountLogin, SubmitOTP::class.java)
                    intent.putExtra("auth", verificationId)
                    startActivity(intent)
                }
            }
        }
    }

    private fun verify() {
        val phoneNum = "+91" + EtPhoneNumber.text.toString()
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNum)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)

    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this@AccountLogin,LanguageSelect::class.java))
                    Log.d("TAG", "signInWithCredential:success")

                    val user = task.result?.user

                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w("TAG", "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                       prosessText.text="Invaild"
                    }
                }
            }
    }
}


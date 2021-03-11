package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pagarbook.DataNConstants.ConstantsNData
import com.example.pagarbook.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class SplashScreen : AppCompatActivity() {


    var cn = ConstantsNData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        sleep(1500)

        if (cn.getLoginStatus(this) == "1"){

            intent = Intent(this@SplashScreen, DetailsActivity::class.java)
            startActivity(intent)

        }
        else{

            intent = Intent(this@SplashScreen, LanguageSelect::class.java)
            startActivity(intent)

        }







    }

}
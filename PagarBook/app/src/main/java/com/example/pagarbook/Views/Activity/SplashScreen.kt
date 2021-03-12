package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pagarbook.DataNConstants.ConstantsNData
import com.example.pagarbook.R

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Thread.sleep
import java.util.*

class SplashScreen : AppCompatActivity() {

    lateinit var locale: Locale
    private var localeName = "en"

    var cn = ConstantsNData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        locale = Locale(localeName)
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.locale = locale
        res.updateConfiguration(conf, dm)

            



        sleep(1500)

        if (cn.getLoginStatus(this) == "1"){

            intent = Intent(this@SplashScreen, DashboardActivity::class.java)
            startActivity(intent)

        }
        else{


            intent = Intent(this@SplashScreen, LanguageSelect::class.java)
            startActivity(intent)

        }







    }

}
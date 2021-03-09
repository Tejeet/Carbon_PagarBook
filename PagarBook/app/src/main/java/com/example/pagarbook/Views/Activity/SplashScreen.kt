package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pagarbook.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


CoroutineScope(Dispatchers.Default).launch {
    sleep(5*1000);
    intent= Intent(this@SplashScreen, LanguageSelect::class.java)
    startActivity(intent)
}
    }
}
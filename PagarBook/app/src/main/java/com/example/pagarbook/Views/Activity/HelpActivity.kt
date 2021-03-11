package com.example.pagarbook.Views.Activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pagarbook.R
import kotlinx.android.synthetic.main.activity_help.*

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        helpBack.setOnClickListener {
            finish()
        }

        playHowToUsePagar.setOnClickListener {
            val intent = Intent(this,WebActivity::class.java)
            intent.putExtra("link","https://youtu.be/rXijl2qxKDk")
            startActivity(intent)
        }
        playHowToAddStaff.setOnClickListener {
            val intent = Intent(this,WebActivity::class.java)
            intent.putExtra("link","https://youtu.be/60S-IofHr-8")
            startActivity(intent)
        }
        fabWhatsApp.setOnClickListener {

            val toNumber = "918962116006"
            // Replace with mobile phone number without +Sign or leading zeros, but with country code.
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.


            val text = "please help"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$toNumber text=$text")

            startActivity(intent);

        }
    }
}
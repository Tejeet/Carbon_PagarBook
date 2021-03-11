package com.example.pagarbook.Views.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pagarbook.R
import kotlinx.android.synthetic.main.activity_add_staff.*

class AddStaffActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_staff)


        btn_continue.setOnClickListener {

            if (!et_staff_name.text.toString().isEmpty() && !et_staff_number.text.toString().isEmpty() ){


            }
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()

    }

}
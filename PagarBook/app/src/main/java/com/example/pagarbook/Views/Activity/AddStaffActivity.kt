package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pagarbook.R
import kotlinx.android.synthetic.main.activity_add_staff.*

class AddStaffActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_staff)


        btn_add_staff.setOnClickListener {

            if (et_staff_name.text.toString().isNotEmpty() && et_staff_number.text.toString().isNotEmpty()){

                val intent = Intent(this,AddStaffSalaryActivity::class.java)
                 intent.putExtra("staffName",et_staff_name.text.toString())
                 intent.putExtra("staffNumber",et_staff_number.text.toString())
                 startActivity(intent)

            }
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()

    }

}
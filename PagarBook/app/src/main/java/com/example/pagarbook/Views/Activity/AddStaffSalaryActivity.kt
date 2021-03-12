package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pagarbook.R
import kotlinx.android.synthetic.main.activity_add_staff.*
import kotlinx.android.synthetic.main.activity_add_staff_salary.*

class AddStaffSalaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_staff_salary)

        val staffName = intent.getStringExtra("staffName")
        val staffNumber = intent.getStringExtra("staffNumber")

        btnBackAddStaffSalary.setOnClickListener {
            finish()
        }

        btnContinueAddStaffSalary.setOnClickListener {

            if (et_staff_amount.text.toString().isNotEmpty() ){

                val intent = Intent(this,OpeningBalance::class.java)

                intent.putExtra("staffAmount",et_staff_amount.text.toString())
                intent.putExtra("staffName",staffName)
                intent.putExtra("staffNumber",staffNumber)

                startActivity(intent)

            }else{
                et_staff_amount.error = "please Enter"

            }
        }
    }
}
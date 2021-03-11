package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pagarbook.R
import kotlinx.android.synthetic.main.activity_add_staff_salary.*
import kotlinx.android.synthetic.main.activity_opening_balance.*

class OpeningBalance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opening_balance)

        val staffName = intent.getStringExtra("staffName")
        val staffNumber = intent.getStringExtra("staffNumber")

        val staffAmount = intent.getStringExtra("staffAmount")


        btnContinueOpeningBalance.setOnClickListener {
            val intent = Intent(this,DashboardActivity::class.java)
            intent.putExtra("openingBalance",et_opening_balance.text.toString())
            intent.putExtra("staffName",staffName)
            intent.putExtra("staffNumber",staffNumber)
            intent.putExtra("staffAmount",staffAmount)
            startActivity(intent)
        }
    }
}
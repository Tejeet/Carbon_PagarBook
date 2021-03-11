package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pagarbook.R
import kotlinx.android.synthetic.main.activity_staffs_months_and_time.*

class StaffsMonthsAndTimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staffs_months_and_time)

        BtContinueStaffMonths.setOnClickListener {
            startActivity(Intent(this,DashboardActivity::class.java))
        }

    }
}
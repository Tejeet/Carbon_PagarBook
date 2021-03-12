package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pagarbook.DataNConstants.ConstantsNData
import com.example.pagarbook.R
import kotlinx.android.synthetic.main.activity_edit_buiness_name.*

class EditBusinessNameActivity : AppCompatActivity() {
    var cn = ConstantsNData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_buiness_name)
        var userName=cn.getUserName(this)
        var business=intent.getStringExtra("business")
        var staff=intent.getStringExtra("staff")
        EtEditBusinessName.setText(business)
        EtEditStaffCount.setText(staff)

        btn_BusinessNameSave.setOnClickListener {
            cn.saveBusiness(this,userName,EtEditBusinessName.text.toString(),EtEditStaffCount.text.toString())
            startActivity(Intent(this,DashboardActivity::class.java))
        }
    }
}
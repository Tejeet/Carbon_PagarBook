package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pagarbook.DataNConstants.ConstantsNData
import com.example.pagarbook.R
import com.example.pagarbook.Views.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_edit_user_name.*

class EditUserNameActivity : AppCompatActivity() {
    var cn = ConstantsNData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user_name)

        var name=intent.getStringExtra("name")
        EtYourNameEdit.setText(name)
        btn_YourNameSave.setOnClickListener {
            var nameChange=EtYourNameEdit.text.toString()
            cn.setUserName(this,nameChange)
            startActivity(Intent(this,DashboardActivity::class.java))
        }
    }
}
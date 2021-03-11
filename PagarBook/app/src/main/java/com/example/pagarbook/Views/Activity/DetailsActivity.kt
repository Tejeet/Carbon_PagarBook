package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pagarbook.DataNConstants.ConstantsNData
import com.example.pagarbook.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    var cn = ConstantsNData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        BtContinueBusinessDeatils.setOnClickListener {
            if(checkBoxDetailsBusiness.isChecked){
                    if(EtYourName.text.toString().isEmpty()){
                        EtYourName.error="Enter Your Name"
                    }else if(etBuinessName.text.toString().isEmpty()){
                        etBuinessName.error="Enter Business Name"
                    }else if(etNoStaffs.text.toString().isEmpty()){
                        etNoStaffs.error="Enter Number of Staffs"
                    }else{

                        cn.saveBusiness(this, EtYourName.text.toString(),etBuinessName.text.toString(),etNoStaffs.text.toString() )
                        startActivity(Intent(this@DetailsActivity,StaffsMonthsAndTimeActivity::class.java))
                    }
            }

        }
    }
}
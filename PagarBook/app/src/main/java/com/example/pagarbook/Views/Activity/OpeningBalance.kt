package com.example.pagarbook.Views.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.pagarbook.ModelsRoomDB.StaffEntity
import com.example.pagarbook.R
import com.example.pagarbook.Repository.PagarBookRepository
import com.example.pagarbook.ViewModel.PagarBookViewModel
import com.example.pagarbook.ViewModel.PagarBookViewModelFactory
import com.example.pagarbook.Views.ApplicationClass.PagarBookApplication
import kotlinx.android.synthetic.main.activity_add_staff_salary.*
import kotlinx.android.synthetic.main.activity_opening_balance.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OpeningBalance : AppCompatActivity() {

    private lateinit var viewModel : PagarBookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opening_balance)

        val staffName = intent.getStringExtra("staffName")
        val staffNumber = intent.getStringExtra("staffNumber")

        val staffAmount = intent.getStringExtra("staffAmount")


        val appObj  = application as PagarBookApplication

        val reposotory : PagarBookRepository = appObj.repository


        val viewModelFactory : PagarBookViewModelFactory = PagarBookViewModelFactory(reposotory)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PagarBookViewModel::class.java)



        btnContinueOpeningBalance.setOnClickListener {
            val intent = Intent(this,DashboardActivity::class.java)

            intent.putExtra("openingBalance",et_opening_balance.text.toString())
            intent.putExtra("staffName",staffName)
            intent.putExtra("staffNumber",staffNumber)
            intent.putExtra("staffAmount",staffAmount)

            val staff = StaffEntity(staffName.toString(), staffNumber.toString(), staffAmount.toString().toInt(), et_opening_balance.text.toString())

            CoroutineScope(Dispatchers.IO).launch {
                viewModel.ADDstaff(staff)
            }

            startActivity(intent)
        }
    }
}
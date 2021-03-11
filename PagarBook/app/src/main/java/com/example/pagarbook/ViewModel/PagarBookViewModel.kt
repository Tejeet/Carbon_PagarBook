package com.example.pagarbook.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pagarbook.Models.OTPResponseDTOModel
import com.example.pagarbook.ModelsRoomDB.StaffEntity
import com.example.pagarbook.Repository.PagarBookRepository

class PagarBookViewModel(val repo : PagarBookRepository) : ViewModel() {

    suspend fun getOTP(mobile : String) : OTPResponseDTOModel{
        return repo.getOTP(mobile)
    }

    fun ADDstaff(data : StaffEntity){
        repo.addSTAFF(data)
    }

    fun GETStaffs() : LiveData<List<StaffEntity>> {
        return repo.getSTAFF()
    }
}
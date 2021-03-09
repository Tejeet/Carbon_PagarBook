package com.example.pagarbook.ViewModel

import androidx.lifecycle.ViewModel
import com.example.pagarbook.ModelsRoomDB.StaffEntity
import com.example.pagarbook.Repository.PagarBookRepository

class PagarBookViewModel(val repo : PagarBookRepository) : ViewModel() {

    fun ADDstaff(data : StaffEntity){
        repo.addSTAFF(data)
    }
}
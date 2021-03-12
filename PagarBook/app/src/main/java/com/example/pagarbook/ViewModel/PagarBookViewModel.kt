package com.example.pagarbook.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pagarbook.Models.OTPResponseDTOModel
import com.example.pagarbook.ModelsRoomDB.AttendanceEntity
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

    fun GETstaffdetailedSalary() : LiveData<List<StaffEntity>> {
        return repo.getSTAFFDetailedSALARY()
    }

    fun ADDAttendance(data : AttendanceEntity){
        repo.addAttendance(data)
    }

    fun GETTOTALPending() : LiveData<String> {
        return repo.getTOTALPending()
    }

    fun GETTOTALSALARYbyuserID(uid: String) : LiveData<String> {
        return repo.getTOTALSALARYbyUSERID(uid)
    }
}
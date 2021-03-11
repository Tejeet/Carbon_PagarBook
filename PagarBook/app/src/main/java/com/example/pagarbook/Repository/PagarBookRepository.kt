package com.example.pagarbook.Repository

import androidx.lifecycle.LiveData
import com.example.pagarbook.Models.OTPResponseDTOModel
import com.example.pagarbook.ModelsRoomDB.PagarBookModelDao
import com.example.pagarbook.ModelsRoomDB.StaffEntity
import com.tejeet.mvvmcoroutine.remote.APIService
import com.tejeet.mvvmcoroutine.remote.RetrofitGenerator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class PagarBookRepository(val pagarBookModelDao: PagarBookModelDao) {

    private val CONTENT_TYPE = "application/json"

    val api : APIService = RetrofitGenerator.getInstance().create(APIService::class.java)

    suspend fun getOTP(mobile: String) : OTPResponseDTOModel{
        return  api.getOTPFORLOGIN(CONTENT_TYPE, "Ok","Login", mobile)
    }

    fun addSTAFF(staffEntity: StaffEntity){

        CoroutineScope(Dispatchers.IO).launch {
            pagarBookModelDao.addStaff(staffEntity)
        }
    }

    fun getSTAFF() : LiveData<List<StaffEntity>>{

        return pagarBookModelDao.getStaffs()

    }

}
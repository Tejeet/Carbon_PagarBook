package com.example.pagarbook.Repository

import com.example.pagarbook.ModelsRoomDB.PagarBookModelDao
import com.example.pagarbook.ModelsRoomDB.StaffEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PagarBookRepository(val pagarBookModelDao: PagarBookModelDao) {


    fun addSTAFF(staffEntity: StaffEntity){

        CoroutineScope(Dispatchers.IO).launch {
            pagarBookModelDao.addStaff(staffEntity)
        }
    }

}
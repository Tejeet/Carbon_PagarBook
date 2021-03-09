package com.example.pagarbook.Views.ApplicationClass

import android.app.Application
import com.example.pagarbook.ModelsRoomDB.PagarBookDatabase
import com.example.pagarbook.Repository.PagarBookRepository

class PagarBookApplication : Application() {

    val pagarBookModelDao by lazy{

        val myRoomDB : PagarBookDatabase = PagarBookDatabase.getDataBase(this)

        myRoomDB.getPageBookDao()
    }

    val repository :PagarBookRepository  by lazy{

        PagarBookRepository(pagarBookModelDao)
    }



}
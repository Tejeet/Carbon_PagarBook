package com.example.pagarbook.Views.Listner

import com.example.pagarbook.ModelsRoomDB.StaffEntity

interface PresentyClickListner {
    fun onPresentClick(staffEntity: StaffEntity)
    fun onHalfDayClick(staffEntity: StaffEntity)
    fun onAbsentClick(staffEntity: StaffEntity)
}
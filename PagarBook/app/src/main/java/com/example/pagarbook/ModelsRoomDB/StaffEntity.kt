package com.example.pagarbook.ModelsRoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "staffDetails")
class StaffEntity(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "mobile") var mobile: String,
    @ColumnInfo(name = "salary") var salary: String,
    @ColumnInfo(name = "salaryCycle") var salaryCycle: String ) {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null

}
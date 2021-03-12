package com.example.pagarbook.ModelsRoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StaffAttendance")
class AttendanceEntity(
    @ColumnInfo(name = "staffid") var staffID: String,
    @ColumnInfo(name = "presenty") var presenty: String,
    @ColumnInfo(name = "status") var status: String,
    @ColumnInfo(name = "dayAmount") var dayamount: String,
    @ColumnInfo(name = "attendanceDate") var attendanceDate: String
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "aid")
    var aid: Int? = null
}
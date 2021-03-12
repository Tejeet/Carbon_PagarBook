package com.example.pagarbook.ModelsRoomDB

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PagarBookModelDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addStaff(staffEntity: StaffEntity)

    @Query("SELECT * FROM staffDetails")
    fun getStaffs() : LiveData<List<StaffEntity>>

    @Query("SELECT staffDetails.id, staffDetails.name, staffDetails.mobile,  SUM(staffattendance.dayAmount) as salary, salaryCycle  FROM  staffDetails LEFT JOIN staffattendance ON staffDetails.id = staffattendance.staffid GROUP BY staffDetails.id ")
    fun getStaffDetailedSalary() : LiveData<List<StaffEntity>>

    @Delete
    fun deleteStaff(staffEntity: StaffEntity)

    @Update
    fun updateStaff(staffEntity: StaffEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAttendance(attendanceEntity: AttendanceEntity)

    @Query("SELECT SUM(dayAmount) as RESAmount  FROM staffattendance")
    fun getTotalPending() : LiveData<String>

    @Query("SELECT SUM(dayAmount) as RESAmount  FROM staffattendance WHERE staffid=:uID ")
    fun getTotalSalarybyUserID(uID : String) : LiveData<String>


}
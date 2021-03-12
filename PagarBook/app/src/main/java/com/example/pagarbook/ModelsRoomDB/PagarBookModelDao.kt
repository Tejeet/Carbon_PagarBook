package com.example.pagarbook.ModelsRoomDB

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PagarBookModelDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addStaff(staffEntity: StaffEntity)

    @Query("SELECT * FROM staffDetails")
    fun getStaffs() : LiveData<List<StaffEntity>>

    @Delete
    fun deleteStaff(staffEntity: StaffEntity)

    @Update
    fun updateStaff(staffEntity: StaffEntity)


}
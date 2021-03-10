package com.example.pagarbook.ModelsRoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StaffEntity::class], version = 1)
abstract class PagarBookDatabase() : RoomDatabase() {

    abstract fun getPageBookDao() : PagarBookModelDao

    companion object{

        var INSTANCE: PagarBookDatabase? = null

        fun getDataBase(context: Context): PagarBookDatabase {

            if (INSTANCE == null) {

                val builder: RoomDatabase.Builder<PagarBookDatabase> = Room.databaseBuilder(
                    context,
                    PagarBookDatabase::class.java,
                    "My_PagarBook_DB"
                )

                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()

                return INSTANCE!!

            } else {
                return INSTANCE!!
            }

        }

    }

}
package com.example.bloc_notes.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entity::class], version = 1)
abstract class RoomDb: RoomDatabase(){


    abstract fun theDao(): Dao?
    companion object{
        private var INSTANCE: RoomDb?=null
        fun getAppDatabase(context: Context): RoomDb?{
            if (INSTANCE == null){
                INSTANCE=
                    Room.databaseBuilder<RoomDb>(context.applicationContext, RoomDb::class.java, "AppDB")
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE
        }
    }
}
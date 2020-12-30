package com.example.bloc_notes.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userinfo")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id : Int = 0,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "note") val note : String
)
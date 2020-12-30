package com.example.bloc_notes.Room

import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {
    @Query("SELECT * FROM userinfo ORDER BY id DESC")
    fun getAllUserInfo(): List<Entity>?

    @Insert
    fun insertNote(user: Entity?)

    @Delete
    fun deleteNote(user: Entity?)

    @Update
    fun updateNote(user: Entity?)
}
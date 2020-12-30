package com.example.bloc_notes.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.bloc_notes.Room.Entity
import com.example.bloc_notes.Room.RoomDb

class MainActivityViewModel(app: Application): AndroidViewModel(app) {

    lateinit var allNotes: MutableLiveData<List<Entity>>

    init {
        allNotes = MutableLiveData()
        getAllNotes()
    }

    fun  getAllNotesObservers(): MutableLiveData<List<Entity>> {
        return allNotes
    }

    fun getAllNotes(){
        val userDao = RoomDb.getAppDatabase(getApplication())?.theDao()
        val list = userDao?.getAllUserInfo()
        allNotes.postValue(list)
    }

    fun insertUserInfo(entity: Entity){
        val userDao = RoomDb.getAppDatabase(getApplication())?.theDao()
        userDao?.insertNote(entity)
        getAllNotes()
    }

    fun updateUserInfo(entity: Entity){
        val userDao = RoomDb.getAppDatabase(getApplication())?.theDao()
        userDao?.updateNote(entity)
        getAllNotes()
    }

    fun deleteUserInfo(entity: Entity){
        val userDao = RoomDb.getAppDatabase(getApplication())?.theDao()
        userDao?.deleteNote(entity)
        getAllNotes()
    }
}
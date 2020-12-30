package com.example.bloc_notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.bloc_notes.Adapter.RecyclerViewAdapter
import com.example.bloc_notes.Room.Entity
import com.example.bloc_notes.ViewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.RowClickListener {

    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewAdapter = RecyclerViewAdapter(this@MainActivity)
            adapter = recyclerViewAdapter
            val divider = DividerItemDecoration(applicationContext, StaggeredGridLayoutManager.VERTICAL)
            addItemDecoration(divider)
        }
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.getAllNotesObservers().observe(this, Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
            recyclerViewAdapter.notifyDataSetChanged()
        })
        saveButton.setOnClickListener {
            val name = nameInput.text.toString()
            val note = noteInput.text.toString()

            if (saveButton.text.equals("Save note")) {
                val user = Entity(0, name, note)
                viewModel.insertUserInfo(user)
            }else{
                val user = Entity(nameInput.getTag(nameInput.id).toString().toInt(), name, note)
                viewModel.updateUserInfo(user)
                saveButton.setText("Save note")
            }
            nameInput.setText("")
            noteInput.setText("")

        }
    }

    override fun onDeleteUserClickListener(user: Entity) {
        viewModel.deleteUserInfo(user)
    }

    override fun onItemClickListener(user: Entity) {
        nameInput.setText(user.name)
        noteInput.setText(user.note)
        nameInput.setTag(nameInput.id, user.id)
        saveButton.setText("Update")
    }
}
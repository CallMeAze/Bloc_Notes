package com.example.bloc_notes.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bloc_notes.R
import com.example.bloc_notes.Room.Entity
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class RecyclerViewAdapter(val listener: RowClickListener): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var items = ArrayList<Entity>()
    fun setListData(data : ArrayList<Entity>){
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return MyViewHolder(inflater, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onItemClickListener(items[position])
        }
        holder.bind(items[position])
    }

    class MyViewHolder(view: View, val listener: RowClickListener): RecyclerView.ViewHolder(view){

        val tvName = view.textViewName
        val tvNote = view.textViewNote
        val deleteID = view.deleteID

        fun bind(data: Entity){

            tvName.text = data.name
            tvNote.text = data.note
            deleteID.setOnClickListener {
                listener.onDeleteUserClickListener(data)
            }
        }
    }

    interface RowClickListener{
        fun onDeleteUserClickListener(user: Entity)
        fun onItemClickListener(user: Entity)
    }

}
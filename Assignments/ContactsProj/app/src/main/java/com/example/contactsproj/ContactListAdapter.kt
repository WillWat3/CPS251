package com.example.contactsproj

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactListAdapter(private val contactItemLayout: Int):
    RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = emptyList()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val outName = holder.outName
        val outNum = holder.outNum
        contactList.let{
            outName.text = it!![position].contactName
            outNum.text= it!![position].contactNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
        ViewHolder{
            val view = LayoutInflater.from(parent.context).inflate(
                contactItemLayout, parent, false)
            return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>){
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var outName: TextView = itemView.findViewById(R.id.nameOut)
        var outNum: TextView = itemView.findViewById(R.id.phoneOut)
    }
}
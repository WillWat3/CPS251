package com.example.intentrecview

import android.content.Intent
import android.icu.number.IntegerWidth
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val vm: MainViewModel): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {




    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, x: Int) {
        val myData = Data("")
            var x = (0..7).random()
            viewHolder.itemTitle.text = myData.titles[x]
            x = (0..7).random()
            viewHolder.itemDetail.text = myData.details[x]
            x = (0..7).random()
            viewHolder.itemImage.setImageResource(myData.images[x])




        viewHolder.itemView.setOnClickListener(){v->
            val i = Intent(v.context,MainActivity2::class.java)
            i.putExtra("titleString", viewHolder.itemTitle.text.toString())
            i.putExtra("detailString", viewHolder.itemDetail.text.toString())
            i.putExtra("imageID",myData.images[x])
            ContextCompat.startActivity(v.context,i,null)

        }
    }

    override fun getItemCount(): Int {
        val myData = Data("")
        return myData.titles.size
    }





    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)


        }
    }
}
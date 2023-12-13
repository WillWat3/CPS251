package com.example.contactsproj

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var contactName: String? = null
    var contactNumber: String? = null



    constructor(){}

    constructor(id: Int, contactname: String, contactnumber: String ){
        this.contactName = contactname
        this.contactNumber = contactnumber
        this.id = id
    }
    constructor(contactname: String, contactnumber: String ){
        this.contactName = contactname
        this.contactNumber = contactnumber
    }



}

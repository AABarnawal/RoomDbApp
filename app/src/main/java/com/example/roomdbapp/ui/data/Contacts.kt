package com.example.roomdbapp.ui.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
data class Contacts(
    var firstname : String,
    var lastname : String,
    var phoneNumber : String,
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
)

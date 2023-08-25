package com.example.roomdbapp.ui.ServiceDao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.roomdbapp.ui.data.Contacts
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactsDao {

    @Upsert
    suspend fun upsertContact(contact:Contacts)

    @Delete
    suspend fun deleteContact(contact:Contacts)

    @Query("SELECT * FROM Contacts")
    fun getContacts(): Flow<List<Contacts>>

}
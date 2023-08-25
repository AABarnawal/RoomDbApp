package com.example.roomdbapp.ui.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdbapp.ui.ServiceDao.ContactsDao
@Database(
    entities = [Contacts::class],
    version = 1,
)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun Contactdao() :ContactsDao

    companion object{
        @Volatile
        private var INSTANCE : ContactDatabase? = null
        fun getdatabase(context: Context): ContactDatabase{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contactsDB"
                    ).build()
                }

            }
            return INSTANCE!!
        }
    }
}
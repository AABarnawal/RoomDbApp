package com.example.roomdbapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.roomdbapp.ui.Screen.HomeScreenApp
import com.example.roomdbapp.ui.ServiceDao.ContactsDao
import com.example.roomdbapp.ui.data.ContactDatabase
import com.example.roomdbapp.ui.data.ContactViewModel
import com.example.roomdbapp.ui.data.Contacts
import com.example.roomdbapp.ui.theme.RoomDbAppTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    lateinit var database :ContactDatabase


    @SuppressLint("CoroutineCreationDuringComposition", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomDbAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    database = ContactDatabase.getdatabase(this)
                        HomeScreenApp(database)

                    }
                }
            }
        }
    }



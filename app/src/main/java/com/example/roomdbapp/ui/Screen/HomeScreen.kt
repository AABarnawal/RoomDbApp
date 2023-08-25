package com.example.roomdbapp.ui.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.roomdbapp.ui.data.ContactDatabase
import com.example.roomdbapp.ui.data.ContactViewModel

import com.example.roomdbapp.ui.data.Contacts
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenApp(
    database : ContactDatabase,
    viewModel : ContactViewModel= viewModel(),
){

    Scaffold(
        topBar = {
                 CenterAlignedTopAppBar(
                     title = {
                         Text(text = "Contacts")
                     }
                 ) 
        },
        floatingActionButton ={
            Button(onClick = { viewModel.showDialouge = true}) {
                Text(text = "Add")
            }
        }
    ) {
        val assetsState by database.Contactdao().getContacts().collectAsState(initial = emptyList())


        if(viewModel.showDialouge) {
            AddContact(database, viewModel)
        }
        val list = database.Contactdao().getContacts()

        LazyColumn(){
            item { 
                Spacer(modifier = Modifier.height(60.dp))
            }
            items(assetsState.size){contact->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(5.dp)
                        .clickable {
                            GlobalScope.launch {
                                database.Contactdao().upsertContact(Contacts(
                                    assetsState[contact].firstname.replace(assetsState[contact].firstname,"hello"),
                                    assetsState[contact].lastname.replace(assetsState[contact].lastname,"hello"),
                                    assetsState[contact].phoneNumber.replace(assetsState[contact].phoneNumber,"hello"),
                                    assetsState[contact].id

                                ))
                            }
                        }
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(.8f)
                    ) {

                        Text(
                            text = "${assetsState[contact].firstname} ${assetsState[contact].lastname}",
                            fontSize = 20.sp
                        )
                        Text(text = "${assetsState[contact].phoneNumber}",fontSize = 15.sp)
                    }
                    Button(onClick = { GlobalScope.launch {
                        database.Contactdao().deleteContact(assetsState[contact])
                    } }) {
                        Text(text = "X")
                    }
                }
            }
        }
    }
}
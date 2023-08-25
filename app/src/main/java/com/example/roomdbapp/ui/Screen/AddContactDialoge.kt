package com.example.roomdbapp.ui.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomdbapp.ui.data.ContactDatabase
import com.example.roomdbapp.ui.data.ContactViewModel
import com.example.roomdbapp.ui.data.Contacts
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContact(database: ContactDatabase, mainviewModel: ContactViewModel,flag : Boolean = true){
    AlertDialog(
        onDismissRequest = {  },
        title = {Text(text = "add Contact")},
        text = {
            Column() {
                TextField(
                    value = mainviewModel.fname,
                    onValueChange = {mainviewModel.fname = it},
                    placeholder = {
                        Text(text = "first name")
                    }
                )
                TextField(
                    value = mainviewModel.lname,
                    onValueChange = {mainviewModel.lname = it},
                    placeholder = {
                        Text(text = "last name")
                    }
                )
                TextField(
                    value = mainviewModel.phnum,
                    onValueChange = {mainviewModel.phnum = it},
                    placeholder = {
                        Text(text = "Phone Number")
                    }
                )
            }
        },
        confirmButton = {
            if(flag==true){
                Button(onClick = {
                    GlobalScope.launch {
                        database.Contactdao().upsertContact(Contacts(
                            mainviewModel.fname,
                            mainviewModel.lname,
                            mainviewModel.phnum,0 ))
                    }
                    mainviewModel.showDialouge = false
                }) {
                    Text(text = "Save")
                }
            }
        }
    )
}
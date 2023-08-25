package com.example.roomdbapp.ui.data

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdbapp.ui.ServiceDao.ContactsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class ContactViewModel() : ViewModel() {

    var ContactList: LiveData<List<Contacts>> = MutableLiveData<List<Contacts>>()
    var showDialouge : Boolean by mutableStateOf(false)
    var fname : String by mutableStateOf("")
    var lname : String by mutableStateOf("")
    var phnum : String by mutableStateOf("")

}
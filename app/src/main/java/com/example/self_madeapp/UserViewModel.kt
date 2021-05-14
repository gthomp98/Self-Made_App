package com.example.self_madeapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.self_madeapp.data.DataRepository

class UserViewModel(app: Application) : AndroidViewModel(app) {

    //gets the user data from the data repo
    private val dataRepo = DataRepository(app)
    val userData = dataRepo.userData

}
package com.example.self_madeapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.self_madeapp.data.DataRepository

class UserViewModel(app: Application) : AndroidViewModel(app) {

    private val dataRepo = DataRepository(app)
    val userData = dataRepo.userData

}
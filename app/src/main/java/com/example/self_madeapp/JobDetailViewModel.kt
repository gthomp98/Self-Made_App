package com.example.self_madeapp

import android.app.Application
import android.print.PrintJobId
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.self_madeapp.data.DataRepository

class JobDetailViewModel(app:  Application) : AndroidViewModel(app) {

    private val dataRepo = DataRepository(app)
    val jobDetailResponse = dataRepo.singleJobsResponse


}
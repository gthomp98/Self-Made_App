package com.example.self_madeapp

import android.app.Application
import androidx.lifecycle.*
import com.example.self_madeapp.data.DataRepository


class JobViewModel(app: Application) : AndroidViewModel(app) {


    private val dataRepo = DataRepository(app)
    val dataResponse = dataRepo.jobsResponse


}

//    private val _loading = MutableLiveData<LoadingState>()
//    val loading: LiveData<LoadingState>
//        get() = _loading
//
//    private val _data = MutableLiveData<List<Job>>()
//    val data: LiveData<List<Job>>
//        get() = _data
//
//    init {
//        fetchData()
//
//    }
//
//    private fun fetchData() {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                _loading.postValue(LoadingState.LOADING)
//                val response = jobApi.getJobsData()
//                if (response.isSuccessful) {
//                    _data.postValue(response.body())
//                    _loading.postValue(LoadingState.LOADED)
//                } else {
//                    _loading.postValue(LoadingState.error(response.message))
//                }
//            } catch (e: Exception) {
//                _loading.postValue(LoadingState.error(e.message))
//        }
//    }
//}




//    private val dataRepo = DataRepository(app)
//    val jobsData = dataRepo.jobsData
//
//    init {
//        CoroutineScope(Dispatchers.IO).launch {
//            val jobData = dataRepo.callWebService()
//        }
//    }
//
//    fun getJobs()
//    {
//        CoroutineScope(Dispatchers.IO).launch {
//            dataRepo.GetJobsFromWeb()
//        }
//    }
//
//}
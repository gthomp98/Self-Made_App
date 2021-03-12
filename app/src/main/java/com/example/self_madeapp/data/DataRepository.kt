package com.example.self_madeapp.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.provider.ContactsContract
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.self_madeapp.WEB_SERVICE_URL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DataRepository (val app: Application) {


    val userData = MutableLiveData <AuthUser>()
    //val jobsData = MutableLiveData <List<Job>>()
    val jobsResponse = MutableLiveData<DataResponse>()

    val singleJobsResponse = MutableLiveData<JobResponse>()

    val userX = User("admin@selfMade.ie","secret")

    init {
        Log.i("Testing", userX.toString())
        CoroutineScope(Dispatchers.IO).launch{
            callWebService()
            getJobsFromWeb()
            getJobByID()
        }
    }

    @WorkerThread
    suspend fun callWebService() {
        if (networkAvailable()) {
            val retrofit = Retrofit.Builder()
                    .baseUrl(WEB_SERVICE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
            val service = retrofit.create(DataService::class.java)

            val userOK = service.userLogin(userX)
            userData.postValue(userOK)
        }
    }

    @WorkerThread
    suspend fun getJobsFromWeb() {
        if(networkAvailable()) {
            val retrofit = Retrofit.Builder()
                    .baseUrl(WEB_SERVICE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
            val service = retrofit.create(DataService::class.java)

            val jobsReturned = service.getJobsData()
                //.body() ?: emptyList()
            jobsResponse.postValue(jobsReturned)
            Log.i("Here", jobsResponse.toString())
        }
    }

    @WorkerThread
    suspend fun getJobByID() {
        if(networkAvailable()) {
            val retrofit = Retrofit.Builder()
                    .baseUrl(WEB_SERVICE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
            val service = retrofit.create(DataService::class.java)

            val singleJobReturned = service.getJobById()
            singleJobsResponse.postValue(singleJobReturned)
            Log.i("Here", singleJobsResponse.toString())
        }
    }

    // getJobById(id...)

    @Suppress("DEPRECATION")
    private fun networkAvailable(): Boolean {
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting ?: false
    }
}

package com.example.self_madeapp.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.self_madeapp.WEB_SERVICE_URL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
//this is the datarepository which contains all of the functions that access the api
class DataRepository (val app: Application) {
    //this creates live data lists that can be pushed to other parts of the app
    val userData = MutableLiveData <AuthUser>()
    val jobsData = MutableLiveData <List<Job>>()
    val jobsResponse = MutableLiveData<DataResponse>()

//this is the user values we use to login
    val userX = User("admin@SelfMade.ie","secret")

    //this is an init block that contains the callwebservice and get jobsfromweb function on app initialization
    init {
        Log.i("Testing", userX.toString())
        CoroutineScope(Dispatchers.IO).launch{
            callWebService()
            getJobsFromWeb()
        }
    }
//this is the call web service function that uses retrofit and moshi to call and parse the json data from the api and post the user value back to the api, so long as network is available
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
//this is the get jobs function, it uses retrofit and moshi to call and parse the json data from the api and return a list, posting the value to the data response
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

//this is the network available function, that uses the connectivity manager plugin to monitor if internet is available and return as either true or false
    @Suppress("DEPRECATION")
    private fun networkAvailable(): Boolean {
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting ?: false
    }
}

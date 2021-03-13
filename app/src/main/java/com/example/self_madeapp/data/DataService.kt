package com.example.self_madeapp.data

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DataService {

    @POST("login")
    suspend fun userLogin(@Body xyz : User) : AuthUser

    @GET("jobs")
    suspend fun getJobsData() : DataResponse

    @GET("jobs/1")
    suspend fun getSingleJob() : JobResponse

}
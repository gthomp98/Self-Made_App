package com.example.self_madeapp.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
//this is the data service interface, that uses retrofit to make calls to the api
interface DataService {
//this is the login request, that is a post, as it both requests and returns data to and from the api
    @POST("login")
    suspend fun userLogin(@Body xyz : User) : AuthUser
//this is the get jobs request which is a get, so it only requests data and doesnt write to the api
    @GET("jobs")
    suspend fun getJobsData() : DataResponse



}
package com.example.self_madeapp.data


//this returns the json data from the api as a list of jobs
data class DataResponse (
    val status: String,
    val data: List<Job>)
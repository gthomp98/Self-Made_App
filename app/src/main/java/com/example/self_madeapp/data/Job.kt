package com.example.self_madeapp.data
//this is the job data class, which each job object is modelled after
data class Job (
    val id : Int,
    val title: String,
    val imageFile: String,
    val salary: Double,
    val description: String,
     val employer : Employer
)



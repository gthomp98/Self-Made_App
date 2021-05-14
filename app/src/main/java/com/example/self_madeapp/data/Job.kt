package com.example.self_madeapp.data

import com.example.self_madeapp.IMAGE_BASE_URL
import com.example.self_madeapp.ImageLinks
import java.util.*

data class Job (
    val id : Int,
    val title: String,
    val imageFile: String,
    val salary: Double,
    val description: String,
    //val company_postal_address: String
     //val employer : Employer
)//{
//    val imageUrl
//    get() = "$IMAGE_BASE_URL/$imageFile.webp"
//    val thumbnailUrl
//    get() = "$IMAGE_BASE_URL/${imageFile}_tn.webp"
//}

package com.example.self_madeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.self_madeapp.data.User
import com.example.self_madeapp.databinding.ProfileFragmentBinding

class ProfileFragment : Fragment() {


    //This is the profile fragment, which dictates the profile view, below is the user profile that is always used to login
    val userProfile = User("admin@selfMade.ie","secret")

    private lateinit var binding: ProfileFragmentBinding

    @SuppressLint("FragmentLiveDataObserve")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //this inflates and displays the profile fragment display
        binding = ProfileFragmentBinding.inflate(inflater, container, false)

        //This displays the users email in the profile
        binding.userEmail.setText(userProfile.email)

        return binding.root
    }



}
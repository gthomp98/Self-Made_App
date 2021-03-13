package com.example.self_madeapp

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.self_madeapp.data.User
import com.example.self_madeapp.databinding.ProfileFragmentBinding

class ProfileFragment : Fragment() {


    val userProfile = User("admin@selfMade.ie","secret")

    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding: ProfileFragmentBinding

    @SuppressLint("FragmentLiveDataObserve")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        binding.userEmail.setText(userProfile.email)

//        val profileImage = "https://qph.fs.quoracdn.net/main-thumb-177317201-200-gqtbcatdgewhmnpsunkgggmggeugzxav.jpeg"
//
//        Glide.with(view.context)
//                .load(profileImage)
//                .into()





        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
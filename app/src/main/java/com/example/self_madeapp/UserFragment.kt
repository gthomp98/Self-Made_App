package com.example.self_madeapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.self_madeapp.databinding.UserFragmentBinding

class UserFragment : Fragment() {

private lateinit var  viewModel: UserViewModel
private lateinit var binding: UserFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        binding = UserFragmentBinding.inflate(inflater,container, false)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        viewModel.userData.observe(viewLifecycleOwner, Observer
        {

            Log.i("Fragment", it.email + it.name)
            view?.findNavController()?.navigate(R.id.action_userFragment_to_jobFragment)
        })
        return binding.root
    }



}
package com.example.self_madeapp

import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.self_madeapp.data.User
import com.example.self_madeapp.databinding.MainFragmentBinding

class MainFragment : Fragment(){

    private lateinit var viewModel: MainViewModel
   // private lateinit var binding: MainFragmentBinding

//
//    override fun onCreateView(
//            inflater: LayoutInflater, container: ViewGroup?,
//            savedInstanceState: Bundle?
//    ): View {
//        binding = MainFragmentBinding.inflate(inflater, container, false)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
//        viewModel.userData.observe(viewLifecycleOwner, Observer
//        {
//          Log.i("Fragment", it.token + it.email + it.name)
//        })



//
//            return binding.root
//    }



}
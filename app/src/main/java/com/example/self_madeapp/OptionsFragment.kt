package com.example.self_madeapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.example.self_madeapp.databinding.OptionsFragmentBinding

class OptionsFragment : Fragment() {


    private lateinit var viewModel: OptionsViewModel
    private lateinit var binding: OptionsFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = OptionsFragmentBinding.inflate(inflater, container, false)

        binding.lightButton.setOnClickListener{
            turnOnLightMode()
        }

        binding.nightButton.setOnClickListener{
            turnOnDarkMode()
        }

        return binding.root





    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OptionsViewModel::class.java)

    }


    private fun turnOnDarkMode(): Boolean {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        return true
    }

    private fun turnOnLightMode(): Boolean {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        return true
    }
}
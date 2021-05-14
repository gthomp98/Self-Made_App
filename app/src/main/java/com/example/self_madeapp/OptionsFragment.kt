package com.example.self_madeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.example.self_madeapp.databinding.OptionsFragmentBinding

//this is the options fragment, this is where the user controlled options are displayed
class OptionsFragment : Fragment() {

    private lateinit var binding: OptionsFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        binding = OptionsFragmentBinding.inflate(inflater, container, false)
        //this is the light mode button
        binding.lightButton.setOnClickListener{
            turnOnLightMode()
        }
        //this is the night mode button
        binding.nightButton.setOnClickListener{
            turnOnDarkMode()
        }

        return binding.root



    }

    //this is the function that turns on dark mode by setting night mode to yes
    private fun turnOnDarkMode(): Boolean {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        return true
    }

    //this is the function that turns on light mode by setting night mode to no
    private fun turnOnLightMode(): Boolean {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        return true
    }
}
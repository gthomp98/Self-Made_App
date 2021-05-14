package com.example.self_madeapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.self_madeapp.data.Job
import com.example.self_madeapp.databinding.JobDetailFragmentBinding

class JobDetailFragment : Fragment() {

//    val jobEntry1 = Job(1, "Ux Job", "", 20.000, "This is a great job")



    private lateinit var viewModel: JobViewModel
    private val args: JobDetailFragmentArgs by navArgs()
    private lateinit var binding: JobDetailFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = JobDetailFragmentBinding.inflate(inflater, container, false)



        viewModel = ViewModelProvider(this).get(JobViewModel::class.java)

        viewModel.dataResponse.observe(viewLifecycleOwner, Observer {


            binding.jobsTitle.setText(it.data[args.jobId-1].title)

            binding.jobsDescription.setText(it.data[args.jobId-1].description)
            binding.jobsSalary.setText(it.data[args.jobId-1].salary.toString()+"00")
           // binding.companyPostalAddress.setText(it.data[args.jobId-1].employer.company_postal_address)

            })






        return binding.root
    }
}
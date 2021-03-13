package com.example.self_madeapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.self_madeapp.data.Job
import com.example.self_madeapp.databinding.JobDetailFragmentBinding

class JobDetailFragment : Fragment() {

    val jobEntry1 = Job(1, "Ux Job", "", 20.000, "This is a great job")



    private lateinit var viewModel: JobDetailViewModel
    private val args: JobDetailFragmentArgs by navArgs()
    private lateinit var binding: JobDetailFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = JobDetailFragmentBinding.inflate(inflater, container, false)
        binding.jobsTitle.setText(jobEntry1.title)
        binding.jobsSalary.setText(jobEntry1.salary.toString())
        binding.jobsDescription.setText(jobEntry1.description)


        viewModel = ViewModelProvider(this).get(JobDetailViewModel::class.java)

        viewModel.jobDetailResponse.observe(viewLifecycleOwner, Observer {

            binding.jobsTitle
            binding.jobsSalary
            binding.jobsDescription
            binding.jobsEmployer


//                binding.jobsTitle.setText(it.job)
//                binding.jobsDescription.setText(it.job)
//                binding.jobsSalary.setText(it.job)
                //binding.jobsRecyclerView.layout Manager = LinearLayoutManager(activity)

            })




        return binding.root
    }
}
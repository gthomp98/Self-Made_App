package com.example.self_madeapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.example.self_madeapp.databinding.JobFragmentBinding

//This is the job fragment where a list of jobs is displayed, it also passes in the job item listener interface from the job list adapter
class JobFragment : Fragment(),
JobListAdapter.JobItemListener {

//This calls the viewmodel, binding, and the job list adapter
    private lateinit var viewModel: JobViewModel
    private lateinit var binding: JobFragmentBinding
    private lateinit var adapter: JobListAdapter


    @SuppressLint("FragmentLiveDataObserve")
    //This is the oncreate view function, this programmatically displays information and binds it to the view
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        //Everything here is what is contained in the view, inflating the xml, calling the view model and the data response, then setting the title description and salary using args
    ): View {

        binding = JobFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(JobViewModel::class.java)
        viewModel.dataResponse.observe(viewLifecycleOwner, Observer {
        //This views the jobs recycler view
            with(binding.jobsRecyclerView)
            {
                setHasFixedSize(true)
            }
            //This uses the adapter to push the data from the data response into the recycler view
            viewModel.dataResponse.observe(viewLifecycleOwner, Observer{
                adapter = JobListAdapter(requireContext(), it.data, this@JobFragment)
                binding.jobsRecyclerView.adapter = adapter


            })

        })



        return binding.root
    }
//This function allows a user to tap on a job and navigate to the job detail fragment passing the job id into the nav graph
    override fun onJobItemClick(jobId: Int) {
        Log.i("Here", "onJobItemClick: received job id $jobId")
        val action = JobFragmentDirections.actionJobFragmentToJobDetailFragment(jobId)
        findNavController().navigate(action)
    }
}


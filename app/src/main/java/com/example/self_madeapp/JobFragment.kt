package com.example.self_madeapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.drawerlayout.widget.DrawerLayout

import androidx.lifecycle.*
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.LOG
import com.example.self_madeapp.data.Job


import com.example.self_madeapp.databinding.JobFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class JobFragment : Fragment(),
JobListAdapter.JobItemListener {




    private lateinit var viewModel: JobViewModel
    private lateinit var binding: JobFragmentBinding
    private lateinit var adapter: JobListAdapter



//    private lateinit var appBarConfiguration: AppBarConfiguration

    @SuppressLint("FragmentLiveDataObserve")

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = JobFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(JobViewModel::class.java)



        viewModel.dataResponse.observe(viewLifecycleOwner, Observer {

            with(binding.jobsRecyclerView)
            {
                setHasFixedSize(true)
            }

            viewModel.dataResponse.observe(viewLifecycleOwner, Observer{
                adapter = JobListAdapter(requireContext(), it.data, this@JobFragment)
                binding.jobsRecyclerView.adapter = adapter
                //binding.jobsRecyclerView.layoutManager = LinearLayoutManager(activity)

            })

        })



        return binding.root
    }

    override fun onJobItemClick(jobId: Int) {
        Log.i("Here", "onJobItemClick: received job id $jobId")
        val action = JobFragmentDirections.actionJobFragmentToJobDetailFragment(jobId)
        findNavController().navigate(action)
    }
}

//    @Suppress("DEPRECATION")
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(JobViewModel::class.java)
//    }


//    private val jobViewModel by viewModel<JobViewModel>()
//    private val binding by lazy {
//        DataBindingUtil.setContentView<JobFragmentBinding>(this, R.layout.job_fragment).run {
//            lifecycleOwner = this@JobFragment
//            viewModel = jobViewModel
//        }
//    }
////////////////////////////////////////////////////////////////////////////////
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        launch {
//
//
//            val retrofit = Retrofit.Builder()
//                    .baseUrl(WEB_SERVICE_URL)
//                    .addConverterFactory(MoshiConverterFactory.create())
//                    .build()
//
//            val api = retrofit.create(DataService::class.java)
//
//            api.getJobsData().enqueue(object : Callback<List<Job>> {
//                override fun onResponse(call: Call<List<Job>>, response: Response<List<Job>>) {
//                    Log.i("daniel", "onResponse")
//                }
//
//                override fun onFailure(call: Call<List<Job>>, t: Throwable) {
//                    Log.i("daniel", "onFailure")
//                }
//
//            })
//        }
//        val jobs = mutableListOf<Job>()
        ////////////////////////////////////////////////////////////
//        for (i in 0..100) {
//            jobs.add(Job("job", 2011-11-11, 2011-11-11, 20.000, "Good one", 2011-11-11, 2011-11-11))
//        }

//        recyclerView.apply {
//            layoutManager = LinearLayoutManager(this@JobFragment)
//            adapter = JobsAdapter(jobs)
//        }


//        jobViewModel.data.observe(this, Observer {
//            Log.e("JobFragment", it.toString())
//        })


//    private val binding by lazy {
//        DataBindingUtil.setContentView<JobFragmentBinding>(this, R.layout.job_fragment).run {
//            lifecycleOwner = this@MainActivity
//            viewModel = jobViewModel
//        }
//    }
///////////////////////////////////////////////////////////////////////////
//    private lateinit var viewModel: JobViewModel
//    private lateinit var binding: MainFragmentBinding
//    private lateinit var adapter: MainRecyclerAdapter
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View {
//        (activity as AppCompatActivity)
//                .supportActionBar?.setDisplayHomeAsUpEnabled(false)
//        setHasOptionsMenu(true)
//
//        //This is the title in the action bar
//        requireActivity().title = getString(R.string.app_name)
//
//        binding = MainFragmentBinding.inflate(inflater, container, false)
//        viewModel = ViewModelProvider(this).get(JobViewModel::class.java)
//
//        with(binding.jobsRecyclerView) {
//            setHasFixedSize(true)
//            val divider = DividerItemDecoration(
//                    context, LinearLayoutManager(context).orientation
//            )
//            addItemDecoration(divider)
//        }
//
//        viewModel.jobsData.observe(viewLifecycleOwner, Observer {
//        Log.i("jobLogging", it.toString())
//            adapter = MainRecyclerAdapter(it, this@JobFragmemt)
//            binding.recyclerView.adapter = adapter
//            binding.recyclerView.LayoutManager=LinearLayoutManager(activity)
//
//        })
//
//
//        Log.i("Testing", "In JobsFragment")
//        viewModel.getJobs()
//        return binding.root

//}


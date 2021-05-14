package com.example.self_madeapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.self_madeapp.databinding.JobDetailFragmentBinding

//This is the job detail fragment, this is the screen that is called to view details about a job
@Suppress("DEPRECATION")
class JobDetailFragment : Fragment() {

    //Introducing the view model, binding the xml and calling safe args to handle passing data between this fragment and the job fragment
    private lateinit var viewModel: JobViewModel
    private val args: JobDetailFragmentArgs by navArgs()
    private lateinit var binding: JobDetailFragmentBinding


    //This is the oncreate view function, this programmatically displays information and binds it to the view
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Everything here is what is contained in the view, inflating the xml, calling the view model and the data response, then setting the title description and salary using args
            binding = JobDetailFragmentBinding.inflate(inflater, container, false)
            viewModel = ViewModelProvider(this).get(JobViewModel::class.java)
            viewModel.dataResponse.observe(viewLifecycleOwner, Observer {

                binding.jobsTitle.setText(it.data[args.jobId - 1].title)
                binding.jobsDescription.setText(it.data[args.jobId - 1].description)
                binding.jobsSalary.setText(it.data[args.jobId - 1].salary.toString() + "00")


            })

//on click function for contact button that creates an intentive action to open another application with the email address below passed in.
        binding.contactButton.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND)
            i.putExtra(Intent.EXTRA_EMAIL, arrayOf("adamPower@firebird.com"))

            i.type = "message/Job Application"

            try {
                startActivity(Intent.createChooser(i, "Send email via :"))
            } catch (ex: ActivityNotFoundException) {

            }

        }
            return binding.root
        }

}
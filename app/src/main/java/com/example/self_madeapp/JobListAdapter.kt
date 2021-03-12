package com.example.self_madeapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.self_madeapp.data.Job
import com.example.self_madeapp.databinding.JobGridItemBinding

class JobListAdapter(val context: Context,
                     val jobsList: List<Job>,
                     private val itemListener: JobItemListener):

RecyclerView.Adapter<JobListAdapter.ViewHolder>(){


    inner class ViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){
        val binding = JobGridItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.job_grid_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = jobsList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val job = jobsList[position]
        with(holder.binding) {
        titleText.text = job.title
        salaryNum.text = job.salary.toString()
            jobId.text = job.id.toString()

//            Glide.with(context)
//                .load(job.imageUrl)
//                .into(companyImage)
            root.setOnClickListener{
                itemListener.onJobItemClick(job.id)
            }
        }

    }

    interface JobItemListener {
        fun onJobItemClick(jobId:Int)
    }

}
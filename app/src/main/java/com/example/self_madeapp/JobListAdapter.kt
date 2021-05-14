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
                      val itemListener: JobItemListener):

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
        val imageUrl = "https://firebirdsql.org/file/about/firebird-logo-200.png"
//            val imageUrl = "https://picsum.photos/200/200?random=1"
            Glide.with(context)
                .load(imageUrl)
                .into(companyImage)
            titleText.setOnClickListener{
                itemListener.onJobItemClick(job.id)
            }
        }

    }

    interface JobItemListener {
        fun onJobItemClick(jobId:Int)
//        fun onJobItemClick(jobId:Int)
    }

}
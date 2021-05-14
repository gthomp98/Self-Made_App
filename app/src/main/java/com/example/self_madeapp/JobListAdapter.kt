package com.example.self_madeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.self_madeapp.data.Job
import com.example.self_madeapp.databinding.JobGridItemBinding

//This is the job list adapter which dictates the recycler view in the job fragment, the job list and item listener interface are also passed in
class JobListAdapter(val context: Context,
                      val jobsList: List<Job>,
                      val itemListener: JobItemListener):


RecyclerView.Adapter<JobListAdapter.ViewHolder>(){

    //This binds the job grid item which is the layout of each item in the recycler view
    inner class ViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){
        val binding = JobGridItemBinding.bind(itemView)
    }
    //displays the list item xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.job_grid_item, parent, false)
        return ViewHolder(view)
    }
//gets the total length of the list
    override fun getItemCount() = jobsList.size

    //logic for making the job title displayed and redirecting the user to the correct job once the name is tapped aswel as getting an image dynamically from glide
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val job = jobsList[position]
        with(holder.binding) {
        titleText.text = job.title
        val imageUrl = "https://firebirdsql.org/file/about/firebird-logo-200.png"

            Glide.with(context)
                .load(imageUrl)
                .into(companyImage)
            titleText.setOnClickListener{
                itemListener.onJobItemClick(job.id)
            }
        }

    }
//this is the interface that contains the job item click function
    interface JobItemListener {
        fun onJobItemClick(jobId:Int)
//        fun onJobItemClick(jobId:Int)
    }

}
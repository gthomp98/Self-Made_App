//package com.example.self_madeapp
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.self_madeapp.data.Job
//import com.example.self_madeapp.databinding.JobGridItemBinding
//
//class MainRecyclerAdapter(private val jobsList: List<Job>):
//RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {
//
//    inner class ViewHolder(itemView: View):
//                RecyclerView.ViewHolder(itemView){
//        val binding = JobGridItemBinding.bind(itemView)
//                    val titleText = itemView.findViewById<TextView>(R.id.titleText)
//                    val salaryNumber = itemView.findViewById<TextView>(R.id.salaryNum)
//                }
//
//
//    override fun getItemCount() = jobsList. size {
//
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//      val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.job_grid_item, parent, false)
//        return ViewHolder(view)
//    }
//
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val job = jobs[position]
//        with(holder) {
//            titleText?.let {
//                it.text = job.title
//                it.contentDescription = job.title
//            }
//            salaryNumber?.let{
//                it.text = job.salary.toString()
//                it.contentDescription = job.salary.toString()
//            }
//        }
//    }
//
//
//}
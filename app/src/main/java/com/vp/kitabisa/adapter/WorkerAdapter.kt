package com.vp.kitabisa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vp.kitabisa.R
import com.vp.kitabisa.model.Recruiters

class WorkerAdapter(private val recruitersList : ArrayList<Recruiters>) : RecyclerView.Adapter<WorkerAdapter.WorkerViewHolder>() {

//    @RequiresApi(Build.VERSION_CODES.N)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.worker_list_item, parent, false)
        return WorkerViewHolder(itemView)
    }

    /*class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = RecruiterCardBinding.bind(view)
    }*/

    override fun onBindViewHolder(holder: WorkerViewHolder, position: Int) {
        val currentItem = recruitersList[position]
        /*holder.workerName.text = currentItem.workerName
        holder.workerTitle.text = currentItem.workerTitle*/
    }

    override fun getItemCount(): Int {
        return recruitersList.size
    }

    class WorkerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        /*val workerName : TextView = itemView.findViewById(R.id.recruiter_worker_name)
        val workerTitle : TextView = itemView.findViewById(R.id.recruiter_worker_title)*/
    }

}
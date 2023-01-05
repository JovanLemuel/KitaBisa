package com.vp.kitabisa.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.vp.kitabisa.R
import com.vp.kitabisa.model.Workers

class RecruiterAdapter(private val workersList : ArrayList<Workers>) : RecyclerView.Adapter<RecruiterAdapter.RecruiterViewHolder>() {

    @RequiresApi(Build.VERSION_CODES.N)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecruiterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recruiter_list_item, parent, false)
        return RecruiterViewHolder(itemView)
    }

    /*class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = RecruiterCardBinding.bind(view)
    }*/

    override fun onBindViewHolder(holder: RecruiterViewHolder, position: Int) {
        val currentItem = workersList[position]
        /*holder.workerName.text = currentItem.workerName
        holder.workerTitle.text = currentItem.workerTitle*/
    }

    override fun getItemCount(): Int {
        return workersList.size
    }

    class RecruiterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        /*val workerName : TextView = itemView.findViewById(R.id.recruiter_worker_name)
        val workerTitle : TextView = itemView.findViewById(R.id.recruiter_worker_title)*/
    }

}
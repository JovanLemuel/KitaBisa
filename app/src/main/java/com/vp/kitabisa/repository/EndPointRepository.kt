package com.vp.kitabisa.repository

import com.vp.kitabisa.retrofit.EndPointApi
import javax.inject.Inject

class EndPointRepository @Inject constructor(private val api: EndPointApi) {
    fun addRecruiter(recruiter_name:String,recruiter_password:String,recruiter_title:String,recruiter_description:String,recruiter_contact:String) =
        api.addRecruiter(recruiter_name,recruiter_password,recruiter_title,recruiter_description,recruiter_contact)

    fun updateRecruiter(recruiter_id:String,recruiter_name:String,recruiter_password:String,recruiter_title:String,recruiter_description:String,recruiter_contact:String) =
        api.updateRecruiter(recruiter_id,recruiter_name,recruiter_password,recruiter_title,recruiter_description,recruiter_contact)

    fun loginRecruiter(recruiter_name:String,recruiter_password:String) = api.loginRecruiter(recruiter_name,recruiter_password)

    suspend fun getRecruiterById(recruiter_id:Int) = api.getRecruiterById(recruiter_id)

    fun addWorker(worker_name:String,worker_password:String,worker_title:String,worker_description:String,worker_contact:String) =
        api.addWorker(worker_name,worker_password,worker_title,worker_description,worker_contact)

    fun updateWorker(worker_id:String,worker_name:String,worker_password:String,worker_title:String,worker_description:String,worker_contact:String) =
        api.updateWorker(worker_id,worker_name,worker_password,worker_title,worker_description,worker_contact)

    fun loginWorker(worker_name:String,worker_password:String) = api.loginWorker(worker_name,worker_password)

    suspend fun getWorkerById(worker_id:Int) = api.getWorkerById(worker_id)
}
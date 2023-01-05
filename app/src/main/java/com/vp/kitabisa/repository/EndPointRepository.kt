package com.vp.kitabisa.repository

import com.vp.kitabisa.retrofit.EndPointApi
import javax.inject.Inject

class EndPointRepository @Inject constructor(private val api: EndPointApi) {
    //    add user
    fun addRecruiter(recruiter_name:String,recruiter_password:String,recruiter_title:String,recruiter_description:String,recruiter_contact:String) =
        api.addRecruiter(recruiter_name,recruiter_password,recruiter_title,recruiter_description,recruiter_contact)

    //    update user
    fun updateRecruiter(recruiter_id:String,recruiter_name:String,recruiter_password:String,recruiter_title:String,recruiter_description:String,recruiter_contact:String) =
        api.updateRecruiter(recruiter_id,recruiter_name,recruiter_password,recruiter_title,recruiter_description,recruiter_contact)

    //  check login
    fun loginRecruiter(recruiter_name:String,recruiter_password:String) = api.loginRecruiter(recruiter_name,recruiter_password)

    //    get user id
    suspend fun getRecruiterById(id:Int) = api.getRecruiterById(id)
}
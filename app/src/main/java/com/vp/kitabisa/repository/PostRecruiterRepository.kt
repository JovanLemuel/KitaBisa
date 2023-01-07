package com.vp.kitabisa.repository

import com.vp.kitabisa.retrofit.EndPointApi
import javax.inject.Inject

class PostRecruiterRepository @Inject constructor(private val api: EndPointApi) {
    /*suspend fun getPostRecruiter(post_recruiter_id:Int)=api.getPostRecruiter(post_recruiter_id)

    fun addPostRecruiter(id_recruiter: String, post_recruiter_title: String, post_recruiter_description: String, post_recruiter_type: String)=
        api.addPostRecruiter(id_recruiter, post_recruiter_title, post_recruiter_description, post_recruiter_type)

    fun updatePostRecruiter(post_recruiter_id: String, post_recruiter_title: String, post_recruiter_description: String, post_recruiter_type: String)=
        api.updatePostRecruiter(post_recruiter_id, post_recruiter_title, post_recruiter_description, post_recruiter_type)

    fun deletePostRecruiter(post_recruiter_id: String)=api.deletePostRecruiter(post_recruiter_id)*/
}
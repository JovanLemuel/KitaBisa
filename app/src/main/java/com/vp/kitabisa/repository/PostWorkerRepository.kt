package com.vp.kitabisa.repository

import com.vp.kitabisa.retrofit.EndPointApi
import javax.inject.Inject

class PostWorkerRepository @Inject constructor(private val api: EndPointApi) {
    /*suspend fun getPostWorker(post_worker_id:Int)=api.getPostWorker(post_worker_id)

    fun addPostWorker(id_worker: String, post_worker_title: String, post_worker_description: String, post_worker_type: String)=
        api.addPostWorker(id_worker, post_worker_title, post_worker_description, post_worker_type)

    fun updatePostWorker(post_worker_id: String, post_worker_title: String, post_worker_description: String, post_worker_type: String)=
        api.updatePostWorker(post_worker_id, post_worker_title, post_worker_description, post_worker_type)

    fun deletePostWorker(post_worker_id: String)=api.deletePostWorker(post_worker_id)*/
}
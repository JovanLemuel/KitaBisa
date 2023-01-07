package com.vp.kitabisa.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vp.kitabisa.model.Recruiters
import com.vp.kitabisa.model.Workers
import com.vp.kitabisa.repository.EndPointRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkersViewModel @Inject constructor(private val repository: EndPointRepository) : ViewModel() {
    fun addWorker(worker_name:String,worker_password:String,worker_title:String,worker_description:String,worker_contact:String)=
        repository.addWorker(worker_name,worker_password,worker_title,worker_description,worker_contact)

    fun loginWorker(worker_name:String,worker_password:String)=repository.loginWorker(worker_name,worker_password)

    fun updateWorker(worker_id:String,worker_name:String,worker_password:String,worker_title:String,worker_description:String,worker_contact:String)=
        repository.updateWorker(worker_id,worker_name,worker_password,worker_title,worker_description,worker_contact)

    suspend fun getWorkerById(worker_id:Int)=repository.getWorkerById(worker_id)

    val _worker : MutableLiveData<Workers> by lazy {
        MutableLiveData<Workers>()
    }

    val worker : LiveData<Workers>
        get() = _worker

    fun getWorkerbyId(worker_id:Int) = viewModelScope.launch {
        repository.getWorkerById(worker_id).let { response ->
            if (response.isSuccessful){
                _worker.postValue(response.body())
            }else{
                Log.e("Get Data","Failed!")
            }
        }
    }


}
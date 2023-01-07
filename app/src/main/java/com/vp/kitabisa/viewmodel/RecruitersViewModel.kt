package com.vp.kitabisa.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vp.kitabisa.model.Recruiters
import com.vp.kitabisa.repository.EndPointRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecruitersViewModel @Inject constructor(private val repository: EndPointRepository) : ViewModel() {
    fun addRecruiter(recruiter_name:String,recruiter_password:String,recruiter_title:String,recruiter_description:String,recruiter_contact:String)=
        repository.addRecruiter(recruiter_name,recruiter_password,recruiter_title,recruiter_description,recruiter_contact)

    fun loginRecruiter(recruiter_name:String,recruiter_password:String)=repository.loginRecruiter(recruiter_name,recruiter_password)

    fun updateRecruiter(recruiter_id:String,recruiter_name:String,recruiter_password:String,recruiter_title:String,recruiter_description:String,recruiter_contact:String)=
        repository.updateRecruiter(recruiter_id,recruiter_name,recruiter_password,recruiter_title,recruiter_description,recruiter_contact)

    suspend fun getRecruiterById(recruiter_id:Int)=repository.getRecruiterById(recruiter_id)

    val _recruiter : MutableLiveData<Recruiters> by lazy {
        MutableLiveData<Recruiters>()
    }

    val recruiter : LiveData<Recruiters>
        get() = _recruiter

    fun getRecruiterbyId(recruiter_id:Int) = viewModelScope.launch {
        repository.getRecruiterById(recruiter_id).let { response ->
            if (response.isSuccessful){
                _recruiter.postValue(response.body())
            }else{
                Log.e("Get Data","Failed!")
            }
        }
    }


}
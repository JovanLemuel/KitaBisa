package com.vp.kitabisa.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.vp.kitabisa.R
import com.vp.kitabisa.databinding.ActivityWorkerRegisterBinding
import com.vp.kitabisa.model.SubmitRegisterWorker
import com.vp.kitabisa.viewmodel.WorkersViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class WorkerRegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWorkerRegisterBinding
    private lateinit var viewModel: WorkersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkerRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.workerLoginTvbutton.setOnClickListener {
            val myIntent = Intent(this, WorkerLoginActivity::class.java)
            startActivity(myIntent)
            finish()
        }

        registerClick()
    }

    private fun registerClick() {
        binding.buttonWorkerRegister.setOnClickListener {
            val worker_name = binding.workerRegisterNameTextInputEditText.text.toString().trim()
            val worker_password = binding.workerRegisterPasswordTextInputEditText.text.toString().trim()
            val worker_title = ""
            val worker_description = ""
            val worker_contact = ""
//            checker
            if (worker_name.isEmpty()) {
                binding.workerRegisterNameTextInputLayout.error="Please fill in name"
            } else {
                binding.workerRegisterNameTextInputLayout.error=""
            }

            if (worker_password.isEmpty()) {
                binding.workerRegisterPasswordTextInputLayout.error="Please fill in password"
            } else {
                binding.workerRegisterPasswordTextInputLayout.error=""
            }

            if (worker_name.isNotEmpty() && worker_password.isNotEmpty()) {
                viewModel= ViewModelProvider(this)[WorkersViewModel::class.java]
                viewModel.addWorker(worker_name,worker_password,worker_title,worker_description,worker_contact).enqueue(object :
                    Callback<SubmitRegisterWorker> {
                    override fun onResponse(call: Call<SubmitRegisterWorker>, response: Response<SubmitRegisterWorker>) {
                        if (response.isSuccessful) {
                            Toast.makeText(this@WorkerRegisterActivity, "Registered Successfully", Toast.LENGTH_SHORT).show()
                            val myIntent = Intent(this@WorkerRegisterActivity, WorkerLoginActivity::class.java)
                            startActivity(myIntent)
                        } else {
                            Toast.makeText(this@WorkerRegisterActivity, "Register Failed, please try again shortly", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<SubmitRegisterWorker>, t: Throwable) {
                        Log.d("WorkerRegisterActivity", "onFailure: ${t.message}")
                    }
                })
            }
        }
    }
}
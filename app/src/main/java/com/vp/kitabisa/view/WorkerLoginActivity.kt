package com.vp.kitabisa.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.vp.kitabisa.R
import com.vp.kitabisa.databinding.ActivityWorkerLoginBinding
import com.vp.kitabisa.model.SubmitLoginWorker
import com.vp.kitabisa.viewmodel.WorkersViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class WorkerLoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWorkerLoginBinding
    private lateinit var viewModel: WorkersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkerLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.workerRegisterTvbutton.setOnClickListener {
            val myIntent = Intent(this, WorkerRegisterActivity::class.java)
            startActivity(myIntent)
            finish()
        }

        loginClick()
    }

    private fun loginClick() {
        binding.buttonWorkerLogin.setOnClickListener {
            val worker_name=binding.workerLoginNameTextInputEditText.text.toString().trim()
            val worker_password=binding.workerLoginPasswordTextInputEditText.text.toString().trim()

            if (worker_name.isEmpty()) {
                binding.workerLoginNameTextInputLayout.error="Please fill in name"
            } else {
                binding.workerLoginNameTextInputLayout.error=""
            }

            if (worker_password.isEmpty()) {
                binding.workerLoginPasswordTextInputLayout.error="Please fill in password"
            } else {
                binding.workerLoginPasswordTextInputLayout.error=""
            }

            if (worker_name.isNotEmpty() && worker_password.isNotEmpty()) {
                viewModel = ViewModelProvider(this).get(WorkersViewModel::class.java)
                viewModel.loginWorker(worker_name, worker_password).enqueue(object :
                    Callback<SubmitLoginWorker> {
                    override fun onResponse(
                        call: Call<SubmitLoginWorker>,
                        response: Response<SubmitLoginWorker>
                    ) {
                        if (response.isSuccessful) {
                            val myIntent = Intent(this@WorkerLoginActivity, WorkerHomeActivity::class.java)
                                .putExtra("login_worker_id", response.body()?.worker_id)
                            WorkerHomeActivity.loginWorker = true
                            startActivity(myIntent)
                        } else {
                            Toast.makeText(this@WorkerLoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<SubmitLoginWorker>, t: Throwable) {
                        Toast.makeText(this@WorkerLoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
                    }
                })


            }
        }
    }
}
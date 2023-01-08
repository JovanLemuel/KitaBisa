package com.vp.kitabisa.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.vp.kitabisa.R
import com.vp.kitabisa.databinding.ActivityLandingPageBinding
import com.vp.kitabisa.databinding.ActivityLoginRecruiterBinding
import com.vp.kitabisa.databinding.ActivityRecruiterHomeBinding
import com.vp.kitabisa.model.SubmitLoginRecruiter
import com.vp.kitabisa.viewmodel.RecruitersViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.vp.kitabisa.view.RecruiterHomeActivity.Companion.loginRecruiter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class RecruiterLoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginRecruiterBinding
    private lateinit var viewModel: RecruitersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginRecruiterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recruiterRegisterTvbutton.setOnClickListener {
            val myIntent = Intent(this, RecruiterRegisterActivity::class.java)
            startActivity(myIntent)
            finish()
        }

        loginClick()
    }

    private fun loginClick() {
        binding.buttonRecruiterLogin.setOnClickListener {
            val recruiter_name=binding.recruiterLoginNameTextInputEditText.text.toString().trim()
            val recruiter_password=binding.recruiterLoginPasswordTextInputEditText.text.toString().trim()

            if (recruiter_name.isEmpty()) {
                binding.recruiterLoginNameTextInputLayout.error="Please fill in name"
            } else {
                binding.recruiterLoginNameTextInputLayout.error=""
            }

            if (recruiter_password.isEmpty()) {
                binding.recruiterLoginPasswordTextInputLayout.error="Please fill in password"
            } else {
                binding.recruiterLoginPasswordTextInputLayout.error=""
            }

            if (recruiter_name.isNotEmpty() && recruiter_password.isNotEmpty()) {
                viewModel = ViewModelProvider(this).get(RecruitersViewModel::class.java)
                viewModel.loginRecruiter(recruiter_name, recruiter_password).enqueue(object : Callback<SubmitLoginRecruiter> {
                    override fun onResponse(
                        call: Call<SubmitLoginRecruiter>,
                        response: Response<SubmitLoginRecruiter>
                    ) {
                        if (response.isSuccessful) {
                            val myIntent = Intent(this@RecruiterLoginActivity, RecruiterHomeActivity::class.java)
                                .putExtra("login_recruiter_id", response.body()?.recruiter_id)
                            loginRecruiter = true
                            startActivity(myIntent)
                        } else {
                            Toast.makeText(this@RecruiterLoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<SubmitLoginRecruiter>, t: Throwable) {
                        Toast.makeText(this@RecruiterLoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
                    }
                })


            }
        }
    }
}
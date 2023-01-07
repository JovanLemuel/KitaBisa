package com.vp.kitabisa.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.vp.kitabisa.R
import com.vp.kitabisa.databinding.ActivityLoginRecruiterBinding
import com.vp.kitabisa.databinding.ActivityRegisterRecruiterBinding
import com.vp.kitabisa.model.SubmitRegisterRecruiter
import com.vp.kitabisa.view.RecruiterHomeActivity.Companion.login_id
import com.vp.kitabisa.viewmodel.RecruitersViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class RecruiterRegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterRecruiterBinding
    private lateinit var viewModel: RecruitersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterRecruiterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recruiterLoginTvbutton.setOnClickListener {
            val myIntent = Intent(this, RecruiterLoginActivity::class.java)
            startActivity(myIntent)
            finish()
        }

        binding.recruiterRegisterLogo.setOnClickListener {
            val myIntent = Intent(this, RecruiterHomeActivity::class.java)
            startActivity(myIntent)
        }

        registerClick()
    }

    private fun registerClick() {
        binding.buttonRecruiterRegister.setOnClickListener {
            val recruiter_name = binding.recruiterRegisterNameTextInputEditText.text.toString().trim()
            val recruiter_password = binding.recruiterRegisterPasswordTextInputEditText.text.toString().trim()
            val recruiter_title = ""
            val recruiter_description = ""
            val recruiter_contact = ""
//            checker
            if (recruiter_name.isEmpty()) {
                binding.recruiterRegisterNameTextInputLayout.error="Please fill in name"
            } else {
                binding.recruiterRegisterNameTextInputLayout.error=""
            }

            if (recruiter_password.isEmpty()) {
                binding.recruiterRegisterPasswordTextInputLayout.error="Please fill in password"
            } else {
                binding.recruiterRegisterPasswordTextInputLayout.error=""
            }

            if (recruiter_name.isNotEmpty() && recruiter_password.isNotEmpty()) {
                viewModel= ViewModelProvider(this)[RecruitersViewModel::class.java]
                viewModel.addRecruiter(recruiter_name,recruiter_password,recruiter_title,recruiter_description,recruiter_contact).enqueue(object :
                    Callback<SubmitRegisterRecruiter> {
                    override fun onResponse(call: Call<SubmitRegisterRecruiter>, response: Response<SubmitRegisterRecruiter>) {
                        if (response.isSuccessful) {
                            Toast.makeText(this@RecruiterRegisterActivity, "Registered Successfully", Toast.LENGTH_SHORT).show()
                            val myIntent = Intent(this@RecruiterRegisterActivity, RecruiterLoginActivity::class.java)
                            startActivity(myIntent)
                        } else {
                            Toast.makeText(this@RecruiterRegisterActivity, "Register Failed, please try again shortly", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<SubmitRegisterRecruiter>, t: Throwable) {
                        Log.d("RecruiterRegisterActivity", "onFailure: ${t.message}")
                    }
                })
            }
        }
    }
}
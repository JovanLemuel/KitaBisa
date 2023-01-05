package com.vp.kitabisa.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vp.kitabisa.R
import com.vp.kitabisa.databinding.ActivityLoginRecruiterBinding
import com.vp.kitabisa.databinding.ActivityRegisterRecruiterBinding

class RecruiterRegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterRecruiterBinding

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
    }
}
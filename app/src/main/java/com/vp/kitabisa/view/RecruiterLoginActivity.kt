package com.vp.kitabisa.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vp.kitabisa.R
import com.vp.kitabisa.databinding.ActivityLandingPageBinding
import com.vp.kitabisa.databinding.ActivityLoginRecruiterBinding
import com.vp.kitabisa.databinding.ActivityRecruiterHomeBinding

class RecruiterLoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginRecruiterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginRecruiterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recruiterRegisterTv.setOnClickListener {
            val myIntent = Intent(this, RecruiterRegisterActivity::class.java)
            startActivity(myIntent)
        }
    }
}
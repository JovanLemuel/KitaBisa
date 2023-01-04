package com.vp.kitabisa.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.vp.kitabisa.R
import com.vp.kitabisa.databinding.ActivityLandingPageBinding
import com.vp.kitabisa.databinding.ActivityRecruiterHomeBinding

class LandingPage : AppCompatActivity() {

    private lateinit var binding : ActivityLandingPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.landingButtonRecruiter.setOnClickListener {
            val myIntent = Intent(this, RecruiterLoginActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun onBackPressed() {
        // To execute back press
        // super.onBackPressed()
    }
}
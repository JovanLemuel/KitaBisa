package com.vp.kitabisa.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vp.kitabisa.R
import com.vp.kitabisa.databinding.ActivityLandingPageBinding
import com.vp.kitabisa.databinding.ActivityLandingRecruiterBinding

class LandingRecruiter : AppCompatActivity() {

    private lateinit var binding : ActivityLandingRecruiterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingRecruiterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
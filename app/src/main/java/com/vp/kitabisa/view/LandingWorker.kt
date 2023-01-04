package com.vp.kitabisa.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vp.kitabisa.R
import com.vp.kitabisa.databinding.ActivityLandingRecruiterBinding
import com.vp.kitabisa.databinding.ActivityLandingWorkerBinding

class LandingWorker : AppCompatActivity() {

    private lateinit var binding : ActivityLandingWorkerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingWorkerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
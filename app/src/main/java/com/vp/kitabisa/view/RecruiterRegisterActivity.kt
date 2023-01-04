package com.vp.kitabisa.view

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
    }
}
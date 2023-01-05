package com.vp.kitabisa.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.vp.kitabisa.R
import com.vp.kitabisa.view.RecruiterHome
import com.vp.kitabisa.view.RecruiterProfile
import com.vp.kitabisa.view.RecruiterSettings
import com.vp.kitabisa.databinding.ActivityRecruiterHomeBinding

class RecruiterHomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRecruiterHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecruiterHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(RecruiterHome())

        binding.bottomNavigationViewRecruiter.setOnItemSelectedListener {

            when(it.itemId){

                R.id.recruiter_home -> replaceFragment(RecruiterHome())
                R.id.recruiter_profile -> replaceFragment(RecruiterProfile())
                R.id.recruiter_settings -> replaceFragment(RecruiterSettings())

                else ->{

                }
            }
            true
        }
    }

    override fun onBackPressed() {
        // To execute back press
        // super.onBackPressed()
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.recruiter_frame_layout,fragment)
        fragmentTransaction.commit()
    }
}
package com.vp.kitabisa.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.vp.kitabisa.R
import com.vp.kitabisa.view.RecruiterHome
import com.vp.kitabisa.view.RecruiterProfile
import com.vp.kitabisa.view.RecruiterSettings
import com.vp.kitabisa.databinding.ActivityRecruiterHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecruiterHomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRecruiterHomeBinding

    companion object {
        var login_recruiter_id=0
        var loginRecruiter = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecruiterHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        login_recruiter_id=intent.getIntExtra("login_recruiter_id", 0)
        val sharedPreference = getSharedPreferences("recruiter_id", MODE_PRIVATE)
        val editor = sharedPreference.edit()
        if (loginRecruiter){
            if (login_recruiter_id !=0){
                editor.putInt("recruiter_id", login_recruiter_id)
                editor.apply()
            }
        }else{
            editor.putInt("recruiter_id", 0)
            editor.apply()
            login_recruiter_id = sharedPreference.getInt("recruiter_id", 0)
        }

        if (sharedPreference.getInt("recruiter_id", 0) != 0){
            login_recruiter_id = sharedPreference.getInt("recruiter_id", 0)
        }
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
package com.vp.kitabisa.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.vp.kitabisa.R
import com.vp.kitabisa.databinding.ActivityWorkerHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkerHomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWorkerHomeBinding

    companion object {
        var login_worker_id=0
        var loginWorker = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkerHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        login_worker_id=intent.getIntExtra("login_worker_id", 0)
        val sharedPreference = getSharedPreferences("worker_id", MODE_PRIVATE)
        val editor = sharedPreference.edit()
        if (loginWorker){
            if (login_worker_id !=0){
                editor.putInt("worker_id", login_worker_id)
                editor.apply()
            }
        }else{
            editor.putInt("worker_id", 0)
            editor.apply()
            login_worker_id = sharedPreference.getInt("worker_id", 0)
        }

        if (sharedPreference.getInt("worker_id", 0) != 0){
            login_worker_id = sharedPreference.getInt("worker_id", 0)
        }
        replaceFragment(WorkerHome())

        binding.bottomNavigationViewWorker.setOnItemSelectedListener {

            when(it.itemId){

                R.id.worker_home -> replaceFragment(WorkerHome())
                R.id.worker_profile -> replaceFragment(WorkerProfile())
                R.id.worker_settings -> replaceFragment(WorkerSettings())

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
        fragmentTransaction.replace(R.id.worker_frame_layout,fragment)
        fragmentTransaction.commit()
    }
}
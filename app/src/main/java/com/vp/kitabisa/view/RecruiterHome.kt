package com.vp.kitabisa.view

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vp.kitabisa.R
import com.vp.kitabisa.adapter.RecruiterAdapter
import com.vp.kitabisa.model.Workers

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecruiterHome.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecruiterHome : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter : RecruiterAdapter
    private lateinit var recyclerView : RecyclerView
    private lateinit var workersArrayList : ArrayList<Workers>

    lateinit var name : Array<String>
    lateinit var title : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recruiter_home, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RecruiterHome.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecruiterHome().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recruiter_recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = RecruiterAdapter(workersArrayList)
        recyclerView.adapter = adapter
    }


    private fun dataInitialize(){
        workersArrayList = arrayListOf<Workers>()

        name = arrayOf(

        )

        title = arrayOf(

        )

        for (i in name.indices){
            val workers = Workers(name[i], title[i])
            workersArrayList.add(workers)
        }
    }
}
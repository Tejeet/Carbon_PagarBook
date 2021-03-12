package com.example.pagarbook.Views.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagarbook.ModelsRoomDB.StaffEntity
import com.example.pagarbook.R
import com.example.pagarbook.Repository.PagarBookRepository
import com.example.pagarbook.ViewModel.PagarBookViewModel
import com.example.pagarbook.ViewModel.PagarBookViewModelFactory
import com.example.pagarbook.Views.Activity.AddStaffActivity
import com.example.pagarbook.Views.Activity.HelpActivity
import com.example.pagarbook.Views.Adapter.StaffsAdapter
import com.example.pagarbook.Views.ApplicationClass.PagarBookApplication
import kotlinx.android.synthetic.main.fragment_staff.*
import kotlinx.android.synthetic.main.fragment_staff.view.*


class StaffFragment : Fragment() {


    private var staffListData : MutableList<StaffEntity> = mutableListOf<StaffEntity>()

    private lateinit var viewModel : PagarBookViewModel

    private val TAG = "tag"

    private lateinit var mAdapter : StaffsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_staff, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val appObj  = activity!!.application as PagarBookApplication

        val reposotory : PagarBookRepository = appObj.repository


        val viewModelFactory : PagarBookViewModelFactory = PagarBookViewModelFactory(reposotory)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PagarBookViewModel::class.java)

        view.tv_staff_count.setOnClickListener {
            startActivity(Intent(context, AddStaffActivity::class.java))
        }

        view.layoutStaffHelp.setOnClickListener {
            startActivity(Intent(context, HelpActivity::class.java))
        }

        viewModel.GETTOTALPending().observe(viewLifecycleOwner,{
            val data = it
            view.tv_balance.text = "₹ $data"
        })



        setRecyclerView()

        viewModel.GETstaffdetailedSalary().observe(viewLifecycleOwner,{

            var list = it

            if (list.size > 1){
                staffListData.clear()
                staffListData.addAll(list)
                mAdapter.updateStaff(staffListData)
                mAdapter.notifyDataSetChanged()

                Log.d(TAG, "Found Employees ${list.size}")
                tvMonthlyStaff.text = "Monthly Staff (${list.size})"
            }

        })


    }

    private fun setRecyclerView(){

        mAdapter = StaffsAdapter(staffListData)
        val linearLayout = LinearLayoutManager(activity)
        rcvStaffView.layoutManager = linearLayout
        rcvStaffView.adapter = mAdapter

    }

}
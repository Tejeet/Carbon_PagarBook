package com.example.pagarbook.Views.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagarbook.ModelsRoomDB.AttendanceEntity
import com.example.pagarbook.ModelsRoomDB.StaffEntity
import com.example.pagarbook.R
import com.example.pagarbook.Repository.PagarBookRepository
import androidx.lifecycle.Observer
import com.example.pagarbook.ViewModel.PagarBookViewModel
import com.example.pagarbook.ViewModel.PagarBookViewModelFactory
import com.example.pagarbook.Views.Activity.HelpActivity
import com.example.pagarbook.Views.Adapter.AttendanceAdapter
import com.example.pagarbook.Views.ApplicationClass.PagarBookApplication
import com.example.pagarbook.Views.Listner.PresentyClickListner
import kotlinx.android.synthetic.main.fragment_attendance.*
import kotlinx.android.synthetic.main.fragment_attendance.view.*
import java.text.SimpleDateFormat
import java.util.*

class AttendanceFragment : Fragment(), PresentyClickListner {

    private var staffListData : MutableList<StaffEntity> = mutableListOf<StaffEntity>()

    private lateinit var viewModel : PagarBookViewModel

    private val TAG = "tag"

    var present = 0;
    var absent = 0;
    var halfDay = 0;

    private lateinit var mAdapter : AttendanceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attendance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.iv_help.setOnClickListener {
            startActivity(Intent(context, HelpActivity::class.java))
        }

        val appObj  = activity!!.application as PagarBookApplication

        val reposotory : PagarBookRepository = appObj.repository


        val viewModelFactory : PagarBookViewModelFactory = PagarBookViewModelFactory(reposotory)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PagarBookViewModel::class.java)

        setRecyclerView()


        viewModel.GETStaffs().observe(viewLifecycleOwner,Observer{

            var list = it
            staffListData.clear()
            staffListData.addAll(list)
            mAdapter.updateStaff(staffListData)
            mAdapter.notifyDataSetChanged()

            Log.d(TAG, "Found Employees ${list.size}")

        })


    }

    private fun setRecyclerView(){

        mAdapter = AttendanceAdapter(staffListData, this)
        val linearLayout = LinearLayoutManager(activity)
        rcvAttendanceView.layoutManager = linearLayout
        rcvAttendanceView.adapter = mAdapter

    }

    override fun onPresentClick(staffEntity: StaffEntity) {
        Log.d(TAG, "Mark Present ${staffEntity.name}")

        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())

        val dayAmount = staffEntity.salary.toString().toInt() / 30;

        val data = AttendanceEntity(staffEntity.id.toString(), "PRESENT", "1", dayAmount.toString() ,currentDate.toString())
        viewModel.ADDAttendance(data)


        tvPresentNo.text = (tvPresentNo.text.toString().toInt()+1).toString()

    }

    override fun onHalfDayClick(staffEntity: StaffEntity) {
        Log.d(TAG, "Mark Half Day ${staffEntity.name}")

        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())

        val dayAmount = (staffEntity.salary.toString().toInt() / 30)/2;

        val data = AttendanceEntity(staffEntity.id.toString(), "HALF_DAY", "1", dayAmount.toString() ,currentDate.toString())
        viewModel.ADDAttendance(data)

        tvHalfNo.text = (tvHalfNo.text.toString().toInt()+1).toString()
    }

    override fun onAbsentClick(staffEntity: StaffEntity) {
        Log.d(TAG, "Mark Absent ${staffEntity.name}")

        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())

        val dayAmount = 0;

        val data = AttendanceEntity(staffEntity.id.toString(), "ABSENT", "1", dayAmount.toString() ,currentDate.toString())
        viewModel.ADDAttendance(data)

        tvAbsentNo.text = (tvAbsentNo.text.toString().toInt()+1).toString()
    }

}
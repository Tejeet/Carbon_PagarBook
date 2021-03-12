package com.example.pagarbook.Views.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pagarbook.Models.Language
import com.example.pagarbook.ModelsRoomDB.StaffEntity
import com.example.pagarbook.R
import com.example.pagarbook.Views.Listner.LanguageSelectClickListner
import com.example.pagarbook.Views.Listner.PresentyClickListner

class AttendanceAdapter(var listStaff: List<StaffEntity>, val listner: PresentyClickListner) : RecyclerView.Adapter<AttendanceViewHoler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHoler {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_attendance, parent, false)
        return AttendanceViewHoler(view)
    }

    override fun onBindViewHolder(holder: AttendanceViewHoler, position: Int) {
        holder.mStaffName.text = listStaff[position].name
        holder.workHour.text = "8 Hours"
        holder.mPresent.setOnClickListener {
            listner.onPresentClick(listStaff[position])
        }

        holder.mAbsent.setOnClickListener {
            listner.onAbsentClick(listStaff[position])
        }

        holder.mHalfDay.setOnClickListener {
            listner.onHalfDayClick(listStaff[position])
        }


    }

    override fun getItemCount(): Int {
        return listStaff.size
    }

     fun updateStaff(listStaff: List<StaffEntity>){
        this.listStaff = listStaff
    }



}

class AttendanceViewHoler(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mStaffName: TextView =
        itemView.findViewById<TextView>(R.id.tv_name)

    val mPresent: TextView =
        itemView.findViewById<TextView>(R.id.btn_present)

    val mAbsent: TextView =
        itemView.findViewById<TextView>(R.id.btn_absent)

    val mHalfDay: TextView =
        itemView.findViewById<TextView>(R.id.btn_half_day)

    val workHour: TextView =
        itemView.findViewById<TextView>(R.id.tv_time)


}
package com.example.pagarbook.Views.Adapter

import android.util.Log
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

class StaffsAdapter(var listStaff: List<StaffEntity>) : RecyclerView.Adapter<StaffsViewHolder>() {
    private val TAG = "tag"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_staff, parent, false)
        return StaffsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StaffsViewHolder, position: Int) {

        Log.d(TAG, "In Data is  ${listStaff[position].name}")

        holder.mStaffName.text = listStaff[position].name
        holder.mStaffPendingPayment.text =  "₹ ${listStaff[position].salary} "

    }

    override fun getItemCount(): Int {
        return listStaff.size
    }

     fun updateStaff(listStaff: List<StaffEntity>){
        this.listStaff = listStaff
    }


}

class StaffsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mStaffName: TextView =
        itemView.findViewById<TextView>(R.id.tv_employee_name)

    val mStaffPendingPayment: TextView =
        itemView.findViewById<TextView>(R.id.tv_payment_type)

}
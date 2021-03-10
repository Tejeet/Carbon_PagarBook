package com.example.pagarbook.Views.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pagarbook.R
import com.example.pagarbook.Views.fragments.AttendanceFragment
import com.example.pagarbook.Views.fragments.PremiumFragment
import com.example.pagarbook.Views.fragments.ProfileFragment
import com.example.pagarbook.Views.fragments.StaffFragment
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val attendanceFragment = AttendanceFragment()
        val premiumFragment = PremiumFragment()
        val profileFragment = ProfileFragment()
        val staffFragment = StaffFragment()


        setCurrentFragment(staffFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){

                R.id.bottomMenuStaff->setCurrentFragment(staffFragment)
                R.id.bottomMenuAttendance->setCurrentFragment(attendanceFragment)
                R.id.bottomMenuPremium->setCurrentFragment(premiumFragment)
                R.id.bottomMenuProfile->setCurrentFragment(profileFragment)

            }
            true
        }
    }


    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.dashboardContainer,fragment)
            commit()
        }
}
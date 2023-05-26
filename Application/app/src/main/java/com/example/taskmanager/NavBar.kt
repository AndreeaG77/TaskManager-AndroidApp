package com.example.taskmanager

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.taskmanager.fragments.TodayFragment
import com.example.taskmanager.fragments.TomorrowFragment
import com.example.taskmanager.fragments.YesterdayFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavBar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_bar)

        val todayFragment = TodayFragment()
        val yesterdayFragment = YesterdayFragment()
        val tomorrowFragment = TomorrowFragment()
        val bottom_navigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

        makeCurrentFragment(todayFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.today -> makeCurrentFragment(todayFragment)
                R.id.previous -> makeCurrentFragment(yesterdayFragment)
                R.id.next -> makeCurrentFragment(tomorrowFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}
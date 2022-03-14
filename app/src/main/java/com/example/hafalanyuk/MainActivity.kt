package com.example.hafalanyuk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val doneFragment = DoneFragment()
        val userFragment = UserFragment()

        makeCurrentFragment(homeFragment)



        val buttom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        buttom_navigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.nav1 -> makeCurrentFragment(doneFragment)
                R.id.nav2 -> makeCurrentFragment(homeFragment)
                R.id.nav3 -> makeCurrentFragment(userFragment)
            }

            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }
    }
}





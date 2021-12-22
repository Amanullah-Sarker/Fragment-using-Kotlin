package com.amanullah.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.amanullah.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)

        makeCurrentFragment(HomeFragment())
        changeFragment()
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerDashboard, fragment)
            commit()
        }

    private fun changeFragment() {
        binding.topNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.homeFragment -> makeCurrentFragment(HomeFragment())
                R.id.listFragment -> makeCurrentFragment(ListFragment())
                R.id.profileFragment -> makeCurrentFragment(ProfileFragment())
            }
            true
        }
    }
}
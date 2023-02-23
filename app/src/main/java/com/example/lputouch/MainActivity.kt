package com.example.lputouch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.lputouch.databinding.ActivityMainBinding
import java.sql.Types.NULL


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

//
//        navController=Navigation.findNavController(this,R.id.fragment)
//        setupWithNavController(binding.bottomnav,navController)


        val dash:Fragment=dashboardFragment()
        val happen:Fragment=newsFragment()
        val rms:Fragment=rmsFragment()
        val quiz:Fragment=quizFragment()

        binding.bottomnav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.dashboardFragment->replaceFragment(dash)
                R.id.newsFragment->replaceFragment(happen)
                R.id.rmsFragment->replaceFragment(rms)
                R.id.quizFragment->replaceFragment(quiz)
            }
            true
        }

    }

    fun replaceFragment(fragment:Fragment) {
        if (fragment != null) {
            val trans = supportFragmentManager.beginTransaction()
            trans.replace(R.id.frame, fragment)
            trans.commit()
        }
    }
}
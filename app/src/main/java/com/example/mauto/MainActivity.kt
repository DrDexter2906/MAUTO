package com.example.mauto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //recupero l id della navigation bar
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val HomeFragment = HomeFragment()
        val CollectionFragment = CollectionFragment()

        //setto il fragment iniziale
        setCurrentFragment(HomeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(HomeFragment)
                R.id.collection -> setCurrentFragment(CollectionFragment)
            }
            true
        }

    }
    //serve a settare com eprimo fragment in questo caso la home
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }

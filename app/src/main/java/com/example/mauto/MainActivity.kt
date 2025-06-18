package com.example.mauto
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mauto.R
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inizializzazione della BottomNavigationView
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_nav)

        // Impostiamo la Home come elemento selezionato di default
        bottomNav.selectedItemId = R.id.nav_home

        // Gestione del cambio di fragmente in base alla selezione (opzionale)
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Aggiungi codice per mostrare il Fragment della Home
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_qr -> {
                    // Aggiungi codice per mostrare il Fragment QR
                    true
                }
                R.id.nav_car -> {
                    // Aggiungi codice per mostrare il Fragment Car
                    loadFragment(CollectionFragment())
                    true
                }
                R.id.nav_ticket -> {
                    // Aggiungi codice per mostrare il Fragment Ticket
                    true
                }
                R.id.nav_account -> {
                    // Aggiungi codice per mostrare il Fragment Account
                    true
                }
                else -> false
            }

        }

    }
    private fun loadFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment) //Id corrispondente a quello nel layout
            .commit()
        return true
    }
}
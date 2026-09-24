package com.latihan.belajarstorage

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView = findViewById<ListView>(R.id.listView)
        
        // Data dummy untuk kontak
        val listKontak = arrayOf(
            "Budi Setyawan",
            "Siti Aminah",
            "Andi Wijaya",
            "Dewi Lestari",
            "Eko Prasetyo",
            "Fani Rahmawati",
            "Guntur Prabowo",
            "Hana Pertiwi",
            "Irfan Hakim",
            "Joko Susilo",
            "Kartika Putri",
            "Lutfi Ramadhan"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listKontak)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedName = listKontak[position]
            Toast.makeText(this, "Menghubungi $selectedName...", Toast.LENGTH_SHORT).show()
        }
    }
}

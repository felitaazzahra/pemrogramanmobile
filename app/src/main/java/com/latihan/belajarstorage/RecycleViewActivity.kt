package com.latihan.belajarstorage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Data Model
data class Kontak(val nama: String, val status: String)

class RecycleViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        
        // Data Dummy
        val listKontak = listOf(
            Kontak("Budi Setyawan", "Ada di kantor"),
            Kontak("Siti Aminah", "Sibuk"),
            Kontak("Andi Wijaya", "Tersedia"),
            Kontak("Dewi Lestari", "Hanya Panggilan Darurat"),
            Kontak("Eko Prasetyo", "Di Sekolah"),
            Kontak("Fani Rahmawati", "Sedang Rapat"),
            Kontak("Guntur Prabowo", "Lagi Tidur"),
            Kontak("Hana Pertiwi", "Pesan Saja"),
            Kontak("Irfan Hakim", "Battery Lemah"),
            Kontak("Joko Susilo", "Di Gym")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = KontakAdapter(listKontak) { kontak ->
            Toast.makeText(this, "Menelepon ${kontak.nama}...", Toast.LENGTH_SHORT).show()
        }
    }
}

// Adapter Class
class KontakAdapter(
    private val list: List<Kontak>,
    private val onClick: (Kontak) -> Unit
) : RecyclerView.Adapter<KontakAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNama: TextView = view.findViewById(R.id.txtNama)
        val txtStatus: TextView = view.findViewById(R.id.txtStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_kontak, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val kontak = list[position]
        holder.txtNama.text = kontak.nama
        holder.txtStatus.text = kontak.status
        holder.itemView.setOnClickListener { onClick(kontak) }
    }

    override fun getItemCount(): Int = list.size
}

package com.example.a2566_login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MahasiswaAdapter(private val listMahasiswa: ArrayList<Mahasiswa>) :
    RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    inner class MahasiswaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tv_nama_mahasiswa)
        val tvNim: TextView = itemView.findViewById(R.id.tv_nim_mahasiswa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_mahasiswa, parent, false)
        return MahasiswaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val data = listMahasiswa[position]
        holder.tvNama.text = data.nama
        holder.tvNim.text = data.nim

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Nama: ${data.nama}\nNIM: ${data.nim}",
                Toast.LENGTH_SHORT
            ).show()

        }
    }

    override fun getItemCount(): Int = listMahasiswa.size
}

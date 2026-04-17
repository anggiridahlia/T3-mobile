package com.example.t3_mobile

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<TextInputEditText>(R.id.etNamaLengkap)
        val tilNama = findViewById<TextInputLayout>(R.id.tilNamaLengkap)
        val rgKelamin = findViewById<RadioGroup>(R.id.rgJenisKelamin)
        val cbMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)
        val cbOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)
        val btnTampilkan = findViewById<Button>(R.id.btnTampilkan)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnTampilkan.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val selectedKelaminId = rgKelamin.checkedRadioButtonId

            if (nama.isEmpty()) {
                tilNama.error = "Nama tidak boleh kosong"
                etNama.requestFocus()
                return@setOnClickListener
            } else {
                tilNama.error = null
                tilNama.isErrorEnabled = false }

            if (selectedKelaminId == -1) {
                Toast.makeText(this, "Pilih jenis kelamin terlebih dahulu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener }

            val rbTerpilih = findViewById<RadioButton>(selectedKelaminId)
            val kelamin = rbTerpilih.text.toString()

            val hobiList = mutableListOf<String>()
            if (cbMembaca.isChecked) hobiList.add("Membaca")
            if (cbCoding.isChecked) hobiList.add("Coding")
            if (cbOlahraga.isChecked) hobiList.add("Olahraga")

            val hobi = if (hobiList.isNotEmpty()) hobiList.joinToString(", ") else "Tidak ada hobi yang dipilih"

            val hasilAkhir = """
                Nama      : $nama
                Kelamin   : $kelamin
                Hobi        : $hobi
            """.trimIndent()

            tvHasil.text = hasilAkhir }
    }
}
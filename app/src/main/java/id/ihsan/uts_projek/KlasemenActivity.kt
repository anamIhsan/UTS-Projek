package id.ihsan.uts_projek

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.ComponentActivity

class KlasemenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_klasemen)

        // Mendefinisikan tombol navigasi untuk mengakses halaman Pertandingan, Klasemen, dan Pemain
        val ButtonPertandingan: Button =findViewById(R.id.buttonPertandingan)
        val ButtonKlasemen: Button =findViewById(R.id.buttonKlasemen)
        val ButtonPemain: Button =findViewById(R.id.buttonPemain)

        // Mendefinisikan TableLayout untuk menampilkan data klasemen tim
        val tableKlasemen = findViewById<TableLayout>(R.id.tableKlasemen)

        // Daftar data klasemen berisi informasi tim, termasuk urutan, logo, nama tim, dan poin
        val data = listOf(
            listOf("Klub", "", "", "Tanding", "Menang", "Seri", "Kalah", "Poin"),
            listOf("1. ", R.drawable.lfc_logo, "Liverpool", "8", "2", "1", "3", "23"),
            listOf("2. ", R.drawable.mci_logo, "Man City", "8", "2", "1", "3", "25"),
            listOf("3. ", R.drawable.avl_logo, "Aston Villa", "8", "2", "1", "3", "26"),
            listOf("4. ", R.drawable.asn_logo, "Arsenal", "8", "2", "1", "3", "42"),
            listOf("5. ", R.drawable.bri_logo, "Brighton", "8", "2", "1", "3", "16"),
            listOf("6. ", R.drawable.chl_logo, "Chealsea", "8", "2", "1", "3", "41"),
            listOf("7. ", R.drawable.tot_logo, "Tottenham", "8", "2", "1", "3", "23"),
            listOf("8. ", R.drawable.mu_logo, "Man UTD", "8", "2", "1", "3", "32"),
            listOf("9. ", R.drawable.new_logo, "Newcastle", "8", "2", "1", "3", "51"),
            listOf("10. ", R.drawable.evr_logo, "Everton", "8", "2", "1", "3", "26"),
            listOf("1. ", R.drawable.lfc_logo, "Liverpool", "8", "2", "1", "3", "23"),
            listOf("2. ", R.drawable.mci_logo, "Man City", "8", "2", "1", "3", "25"),
            listOf("3. ", R.drawable.avl_logo, "Aston Villa", "8", "2", "1", "3", "26"),
            listOf("4. ", R.drawable.asn_logo, "Arsenal", "8", "2", "1", "3", "42"),
            listOf("5. ", R.drawable.bri_logo, "Brighton", "8", "2", "1", "3", "16"),
            listOf("6. ", R.drawable.chl_logo, "Chealsea", "8", "2", "1", "3", "41"),
            listOf("7. ", R.drawable.tot_logo, "Tottenham", "8", "2", "1", "3", "23"),
            listOf("8. ", R.drawable.mu_logo, "Man UTD", "8", "2", "1", "3", "32"),
            listOf("9. ", R.drawable.new_logo, "Newcastle", "8", "2", "1", "3", "51"),
            listOf("10. ", R.drawable.evr_logo, "Everton", "8", "2", "1", "3", "26"),
            listOf("1. ", R.drawable.lfc_logo, "Liverpool", "8", "2", "1", "3", "23"),
            listOf("2. ", R.drawable.mci_logo, "Man City", "8", "2", "1", "3", "25"),
            listOf("3. ", R.drawable.avl_logo, "Aston Villa", "8", "2", "1", "3", "26"),
            listOf("4. ", R.drawable.asn_logo, "Arsenal", "8", "2", "1", "3", "42"),
            listOf("5. ", R.drawable.bri_logo, "Brighton", "8", "2", "1", "3", "16"),
            listOf("6. ", R.drawable.chl_logo, "Chealsea", "8", "2", "1", "3", "41"),
            listOf("7. ", R.drawable.tot_logo, "Tottenham", "8", "2", "1", "3", "23"),
            listOf("8. ", R.drawable.mu_logo, "Man UTD", "8", "2", "1", "3", "32"),
            listOf("9. ", R.drawable.new_logo, "Newcastle", "8", "2", "1", "3", "51"),
            listOf("10. ", R.drawable.evr_logo, "Everton", "8", "2", "1", "3", "26"),
        )

        // Aksi pada tombol untuk berpindah ke halaman Pertandingan dengan menghapus aktivitas sebelumnya
        ButtonPertandingan.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Aksi pada tombol untuk tetap berada di halaman Klasemen, dengan menghapus aktivitas sebelumnya
        ButtonKlasemen.setOnClickListener {
            val intent = Intent(this, KlasemenActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Aksi pada tombol untuk menuju ke halaman Pemain dengan menghapus aktivitas sebelumnya
        ButtonPemain.setOnClickListener {
            val intent = Intent(this, PemainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Menambahkan setiap baris data ke dalam TableLayout
        data.forEachIndexed { index1, row ->
            val tableRow = TableRow(this)
            tableRow.layoutParams = TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
            )

            // Menambahkan setiap data di baris sebagai cell di dalam row tabel
            row.forEachIndexed { index, cellData ->
                // Baris pertama (header tabel), setiap cell diatur sebagai TextView
                if (index1 === 0) {
                    val cellTextView = TextView(this)
                    cellTextView.text = cellData.toString()
                    cellTextView.setPadding(16, 16, 16, 16)
                    cellTextView.gravity = Gravity.CENTER
                    tableRow.addView(cellTextView)
                } else {
                    // Untuk cell kedua pada baris data, gunakan ImageView sebagai logo tim
                    if (index === 1) {
                        val cellImageView = ImageView(this).apply {
                            setImageResource(cellData as Int)

                            layoutParams = TableRow.LayoutParams(60,  60) // Mengatur ukuran gambar

                            background = resources.getDrawable(R.drawable.image_klasemen_rounded, null) // Gambar dengan sudut membulat
                        }
                        tableRow.addView(cellImageView)
                    } else {
                        // Selain cell logo, tambahkan TextView untuk nama tim dan detail lainnya
                        val cellTextView = TextView(this)
                        cellTextView.text = cellData.toString()
                        cellTextView.setPadding(16, 16, 16, 16)
                        cellTextView.gravity = Gravity.CENTER
                        tableRow.addView(cellTextView)
                    }
                }
            }

            // Tambahkan TableRow ke TableLayout
            tableKlasemen.addView(tableRow)
        }
    }
}
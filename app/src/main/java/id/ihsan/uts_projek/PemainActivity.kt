package id.ihsan.uts_projek

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.ComponentActivity

class PemainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemain)

        // Menyiapkan tombol untuk berpindah antar halaman aktivitas
        val ButtonPertandingan: Button =findViewById(R.id.buttonPertandingan)
        val ButtonKlasemen: Button =findViewById(R.id.buttonKlasemen)
        val ButtonPemain: Button =findViewById(R.id.buttonPemain)

        // Mengatur tombol untuk membuka halaman Pertandingan
        ButtonPertandingan.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Mengatur tombol untuk membuka halaman Klasemen
        ButtonKlasemen.setOnClickListener {
            val intent = Intent(this, KlasemenActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Mengatur tombol untuk tetap berada di halaman Pemain
        ButtonPemain.setOnClickListener {
            val intent = Intent(this, PemainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Membuat data class untuk menyimpan informasi pemain seperti foto, logo klub, nama, posisi, dan nama klub
        data class Pemain(val foto: Int, val gclub: Int, val nama: String, val posisi: String, val nclub: String)

        // Daftar objek pemain yang akan digunakan untuk menampilkan data di layar
        val pemains = listOf(
            Pemain(R.drawable.pemain1, R.drawable.mci_logo, "Erling Haaland", "Penyerang", "Man City"),
            Pemain(R.drawable.pemain2, R.drawable.chl_logo, "Cole Palmer", "Penyerang", "Chelsea"),
            Pemain(R.drawable.pemain4, R.drawable.lfc_logo, "M. Salah", "Penyerang", "Liverpool"),
            Pemain(R.drawable.pemain5, R.drawable.mu_logo, "Joshua", "Penyerang", "Man Utd"),
            Pemain(R.drawable.pemain3, R.drawable.evr_logo, "Erling Haram", "Penyerang", "Everton"),
            Pemain(R.drawable.pemain6, R.drawable.tot_logo, "Erling Haram", "Penyerang", "Brighton"),
            Pemain(R.drawable.pemain7, R.drawable.bri_logo, "Silva", "Gelandang", "Tottenham"),
            Pemain(R.drawable.pemain8, R.drawable.new_logo, "Erling Haram", "Gelandang", "Newcastle"),
            Pemain(R.drawable.pemain9, R.drawable.mci_logo, "Erling Haram", "Gelandang", "Man City"),
            Pemain(R.drawable.pemain10, R.drawable.lfc_logo, "G. Jesus", "Gelandang", "Liverpool"),
            Pemain(R.drawable.pemain11, R.drawable.mci_logo, "Erling Haram", "Gelandang", "Man City"),
            Pemain(R.drawable.pemain12, R.drawable.mu_logo, "Rice", "Gelandang", "Man Utd"),
            Pemain(R.drawable.pemain13, R.drawable.new_logo, "Erling Haram", "Penyerang", "Liverpool"),
            Pemain(R.drawable.pemain14, R.drawable.tot_logo, "Valdes", "Penyerang", "Tottenham"),
            Pemain(R.drawable.pemain15, R.drawable.lfc_logo, "Erling Haram", "Gelandang", "Liverpool"),
        )

        // Mendapatkan GridLayout dari layout utama untuk menampilkan daftar pemain
        val gridLayoutPemain = findViewById<GridLayout>(R.id.gridLayoutPemain)

        // Menginisialisasi LayoutInflater untuk menginflate layout item_card_pemain
        val inflater = LayoutInflater.from(this)

        // Menambahkan data setiap pemain ke dalam grid layout secara otomatis
        for (pemain in pemains) {
            // Menginflate layout item_card_pemain ke dalam grid layout untuk setiap pemain
            val itemViewPemain = inflater.inflate(R.layout.item_card_pemain, gridLayoutPemain, false)

            // Menemukan elemen di layout item_card_pemain dan mengisi data dari setiap objek pemain
            val imageViewFoto = itemViewPemain.findViewById<ImageView>(R.id.imageViewFoto)
            val imageViewGclub = itemViewPemain.findViewById<ImageView>(R.id.imageViewGclub)
            val textViewName = itemViewPemain.findViewById<TextView>(R.id.textViewName)
            val textViewPosisi = itemViewPemain.findViewById<TextView>(R.id.textViewPosisi)
            val textViewNclub = itemViewPemain.findViewById<TextView>(R.id.textViewNclub)

            // Mengatur gambar dan teks berdasarkan informasi dari setiap objek pemain
            imageViewFoto.setBackgroundResource(pemain.foto)
            imageViewGclub.setBackgroundResource(pemain.gclub)
            textViewName.text = pemain.nama
            textViewPosisi.text = pemain.posisi
            textViewNclub.text = pemain.nclub

            // Menambahkan tampilan pemain ke dalam GridLayout
            gridLayoutPemain.addView(itemViewPemain)
        }
    }
}
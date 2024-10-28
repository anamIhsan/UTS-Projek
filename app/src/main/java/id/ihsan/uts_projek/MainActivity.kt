package id.ihsan.uts_projek

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mendeklarasikan tombol untuk navigasi ke halaman lain
        val ButtonPertandingan: Button =findViewById(R.id.buttonPertandingan)
        val ButtonKlasemen: Button =findViewById(R.id.buttonKlasemen)
        val ButtonPemain: Button =findViewById(R.id.buttonPemain)

        // Mengatur tombol "Pertandingan" untuk membuka halaman yang sama, menghapus aktivitas sebelumnya
        ButtonPertandingan.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Mengatur tombol "Klasemen" untuk membuka halaman KlasemenActivity
        ButtonKlasemen.setOnClickListener {
            val intent = Intent(this, KlasemenActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Mengatur tombol "Pemain" untuk membuka halaman PemainActivity
        ButtonPemain.setOnClickListener {
            val intent = Intent(this, PemainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Membuat data class untuk menyimpan informasi pertandingan
        data class Pertandingan(val gtim1: Int, val gtim2: Int, val tim1: String, val tim2: String, val stim1: String, val stim2: String)

        // Menyusun daftar pertandingan termasuk logo tim, nama tim, dan skor atau tanggal pertandingan
        val pertandingans = listOf(
            Pertandingan(R.drawable.lfc_logo, R.drawable.mci_logo, "Liverpool", "Man City", "2", "0"),
            Pertandingan(R.drawable.mci_logo, R.drawable.mu_logo, "Man City", "Man Utd", "0", "2"),
            Pertandingan(R.drawable.mu_logo, R.drawable.tot_logo, "Man Utd", "Tottenham", "1", "3"),
            Pertandingan(R.drawable.tot_logo, R.drawable.bri_logo, "Tottenham", "Brighton", "2", "4"),
            Pertandingan(R.drawable.bri_logo, R.drawable.avl_logo, "Brighton", "Aston Villa", "1", "2"),
            Pertandingan(R.drawable.avl_logo, R.drawable.evr_logo, "Aston Villa", "Everton", "Sabtu", "23/10/24"),
            Pertandingan(R.drawable.new_logo, R.drawable.chl_logo, "Newcastle", "Chelsea", "Minggu", "24/10/24"),
            Pertandingan(R.drawable.chl_logo, R.drawable.lfc_logo, "Chelsea", "Liverpool", "Sabtu", "30/10/24"),
            Pertandingan(R.drawable.tot_logo, R.drawable.new_logo, "Tottenham", "Newcastle", "Minggu", "31/10/24"),
            Pertandingan(R.drawable.evr_logo, R.drawable.new_logo, "Everton", "Newcastle", "Kamis", "4/11/24"),
        )

        // Mendapatkan referensi layout utama untuk menampilkan daftar pertandingan
        val linearLayoutCard = findViewById<LinearLayout>(R.id.linearLayoutCard)

        // Mengatur inflater untuk menggandakan item layout untuk setiap pertandingan
        val inflater = LayoutInflater.from(this)

        // Loop untuk membuat tampilan setiap pertandingan secara dinamis
        for (pertandingan in pertandingans) {
            // Inflate item layout dan tambahkan ke linear layout utama
            val itemView = inflater.inflate(R.layout.item_card_pertandingan, linearLayoutCard, false)

            // Menghubungkan elemen UI dengan elemen layout item card
            val imageViewGambarTim1 = itemView.findViewById<ImageView>(R.id.imageViewTim1)
            val imageViewGambarTim2 = itemView.findViewById<ImageView>(R.id.imageViewTim2)
            val textViewNameTim1 = itemView.findViewById<TextView>(R.id.textViewNameTim1)
            val textViewNameTim2 = itemView.findViewById<TextView>(R.id.textViewNameTim2)
            val textViewScoreTim1 = itemView.findViewById<TextView>(R.id.textViewScoreTim1)
            val textViewScoreTim2 = itemView.findViewById<TextView>(R.id.textViewScoreTim2)

            // Mengatur gambar dan teks sesuai data pertandingan
            imageViewGambarTim1.setBackgroundResource(pertandingan.gtim1)
            imageViewGambarTim2.setBackgroundResource(pertandingan.gtim2)
            textViewNameTim1.text = pertandingan.tim1
            textViewNameTim2.text = pertandingan.tim2
            textViewScoreTim1.text = pertandingan.stim1
            textViewScoreTim2.text = pertandingan.stim2

            // Menambahkan item card ke layout utama
            linearLayoutCard.addView(itemView)
        }
    }
}

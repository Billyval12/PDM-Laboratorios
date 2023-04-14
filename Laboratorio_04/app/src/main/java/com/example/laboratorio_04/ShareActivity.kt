package com.example.laboratorio_04


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ShareActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var numberTextView: TextView
    private lateinit var shareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        bind()

        val nameShared = intent.getStringExtra("name").toString()
        val emailShared = intent.getStringExtra("email").toString()
        val numberShared = intent.getStringExtra("number").toString()
        nameTextView.text = "Nombre: ${nameShared}"
        emailTextView.text = "Correo eléctronico: ${emailShared}"
        numberTextView.text = "Número de teléfono: ${numberShared}"

        shareButton.setOnClickListener { share() }

    }

    private fun bind() {
        nameTextView = findViewById(R.id.name_text_view)
        emailTextView = findViewById(R.id.email_text_view)
        numberTextView = findViewById(R.id.number_text_view)
        shareButton = findViewById(R.id.share_button)
    }

    private fun share() {
        val name = nameTextView.text
        val email = emailTextView.text
        val phone = numberTextView.text
        val intent = Intent().apply{
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,"${name} \n${email}\n${phone}")
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(intent, null)
        startActivity(shareIntent)
    }
}
package com.example.laboratorio_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var numberEditText: TextInputEditText
    private lateinit var actionNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        actionNext.setOnClickListener {
            val intent = Intent(this, ShareActivity::class.java)
            intent.putExtra("name", nameEditText.text.toString())
            intent.putExtra("email", emailEditText.text.toString())
            intent.putExtra("number", numberEditText.text.toString())
            startActivity(intent)
        }
    }

    private fun bind() {
        nameEditText = findViewById(R.id.name_value)
        emailEditText = findViewById(R.id.email_value)
        numberEditText = findViewById(R.id.number_value)
        actionNext = findViewById(R.id.action_share)
    }


    companion object {
        const val SHARE_NAME = "name"
        const val SHARE_EMAIL = "email"
        const val SHARE_NUMBER = "number"
    }
}
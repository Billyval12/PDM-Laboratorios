package com.example.laboratorio_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var fiveCents: ImageView
    private lateinit var tenCents: ImageView
    private lateinit var quarter: ImageView
    private lateinit var oneDollar: ImageView
    private lateinit var cashTextView: TextView
    private var cash = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        changeButton()
    }

    private fun changeButton() {
        fiveCents.setOnClickListener {
            cash += 0.05
            cash = String.format("%.2f", cash).toDouble()
            cashTextView.text = "$${cash}"
        }
        tenCents.setOnClickListener {
            cash += 0.10
            cash = String.format("%2f", cash).toDouble()
            cashTextView.text = "$${cash}"
        }
        quarter.setOnClickListener {
            cash += 0.25
            cash = String.format("%.2f", cash).toDouble()
            cashTextView.text = "$${cash}"
        }
        oneDollar.setOnClickListener {
            cash += 1.00
            cash = String.format("%.2f", cash).toDouble()
            cashTextView.text = "$${cash}"
        }
    }

    private fun bind() {
        fiveCents = findViewById(R.id.five_cents_image_view)
        tenCents = findViewById(R.id.ten_cents_image_view)
        quarter = findViewById(R.id.quarter_image_view)
        oneDollar = findViewById(R.id.one_dollar_image_view)
        cashTextView = findViewById(R.id.cash_text_view)
    }

}

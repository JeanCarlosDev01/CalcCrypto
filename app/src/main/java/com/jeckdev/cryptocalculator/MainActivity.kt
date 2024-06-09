package com.jeckdev.cryptocalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private lateinit var btnFuturePrice:Button
    private lateinit var btnBuyCrypto:Button
    private lateinit var btnPercent:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnInit()
        startLayout()

    }
    private fun btnInit() {
        btnFuturePrice = findViewById(R.id.btnFuturePrice)
        btnBuyCrypto = findViewById(R.id.btnBuyCrypto)
        btnPercent = findViewById(R.id.btnPercent)
    }
    private fun startLayout() {
        btnFuturePrice.setOnClickListener {priceCrypto()}
        btnBuyCrypto.setOnClickListener {buyCrypto()}
        btnPercent.setOnClickListener {percent()}
    }
    private fun priceCrypto() {
        val intent = Intent(this, GainActivity::class.java)
        startActivity(intent)
    }
    private fun buyCrypto() {
        val intent = Intent(this, BuyActivity::class.java)
        startActivity(intent)
    }
    private fun percent() {
        val intent = Intent(this, PercentActivity::class.java)
        startActivity(intent)
    }

}
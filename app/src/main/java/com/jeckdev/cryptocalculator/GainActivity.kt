package com.jeckdev.cryptocalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class GainActivity : AppCompatActivity() {
    private lateinit var display:TextView
    private lateinit var inputAmountCoin:EditText
    private lateinit var inputActualPrice:EditText
    private lateinit var inputFutureCoin:EditText
    private lateinit var btnCalcGain:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gain)


        elements()
        listener()
    }
    private fun elements() {
        display = findViewById(R.id.viewTotalGain)
        inputAmountCoin = findViewById(R.id.amountCoins)
        inputActualPrice = findViewById(R.id.etActualPrice)
        inputFutureCoin = findViewById(R.id.etFuturePrice)
        btnCalcGain = findViewById(R.id.btnCalcGain)

    }
    private fun values() {

        val amountCoins = inputAmountCoin.text.toString()
        val actualPrice = inputActualPrice.text.toString()
        val futurePrice = inputFutureCoin.text.toString()

        if (amountCoins != "" && actualPrice != "" && futurePrice != "") {
            gain(amountCoins.toFloat(), actualPrice.toDouble(), futurePrice.toDouble())
        }else {
            display.text = getString(R.string.display_error)
        }
    }
    private fun gain(coins:Float, actualPrice:Double, futurePrice:Double) {
        val gain:Double = (coins * futurePrice) - (coins * actualPrice)
        viewGain(gain)
    }
    private fun listener() {
        btnCalcGain.setOnClickListener { values() }
    }
    private fun viewGain(value:Double) {
        val df = String.format("%.2f", value)
        display.text = df
    }
}
package com.jeckdev.cryptocalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BuyActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private lateinit var btnCalculate: Button
    private lateinit var btnLayoutPrice:Button
    private lateinit var inputMoney:EditText
    private lateinit var inputPrice:EditText

    private var amount:String = ""
    private var price:String = ""
    private var coins:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy)

        elements()
        clickListener()
    }
    private fun elements() {
        display = findViewById(R.id.viewTotalCrypto)
        btnCalculate = findViewById(R.id.btnCalcBuy)
        btnLayoutPrice = findViewById(R.id.btnFuturePrice)
        inputMoney = findViewById(R.id.etMoney)
        inputPrice = findViewById(R.id.etPrice)
    }
    private fun inputValue() {
        amount = inputMoney.text.toString()
        price = inputPrice.text.toString()

        if (amount != "" && price != "") {
            calcBuy(amount.toFloat(), price.toDouble())
        }else {
            display.text = getString(R.string.display_error)
        }
    }
    private fun viewCoin(value:Double) {
        val coins = String.format("%.2f",value)
        display.text = coins
    }
    private fun calcBuy (money:Float, price:Double) {
        val coin = money / price
        coins = coin.toString()
        viewCoin(coin)
    }
    private fun clickListener() {
        btnCalculate.setOnClickListener {inputValue()}
        btnLayoutPrice.setOnClickListener { priceCrypto() }
    }
    private fun priceCrypto() {
        val intent = Intent(this, GainActivity::class.java)
        intent.putExtra("AMOUNT",coins)
        startActivity(intent)
    }
}

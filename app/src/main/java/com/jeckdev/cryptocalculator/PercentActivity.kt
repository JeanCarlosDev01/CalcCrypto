package com.jeckdev.cryptocalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class PercentActivity : AppCompatActivity() {
    private lateinit var inputActualPrice: EditText
    private lateinit var inputCap: EditText
    private lateinit var objectivePrice: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var display: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_percent)
        elements()
        btn()
    }
    private fun elements() {
        inputActualPrice = findViewById(R.id.etCrypto)
        inputCap = findViewById(R.id.etCap)
        objectivePrice = findViewById(R.id.etObjective)
        buttonCalculate = findViewById(R.id.btnCalcPerc)
        display = findViewById(R.id.displayPercent)
    }
    private fun inputValue() {
        var acPrice = inputActualPrice.text.toString()
        var capCir = inputCap.text.toString()
        var fuPrice = objectivePrice.text.toString()

        if (acPrice != "" && capCir != "" && fuPrice !="" ) {
            calc(acPrice.toDouble(), capCir.toLong(), fuPrice.toDouble())
        }else {
            display.text = getString(R.string.display_error)
        }

    }
    private fun calc(price:Double, cap:Long, future:Double) {
        var capActual = price * cap
        var capNece = future * cap
        var difCap = capNece - capActual
        var percent:Double = (difCap / capActual) * 100

        display(percent)
    }
    private fun display(value:Double) {
        val df = String.format("%.2f", value)
        display.text = "$df %"
    }
    private fun btn() {
        buttonCalculate.setOnClickListener { inputValue() }
    }
}
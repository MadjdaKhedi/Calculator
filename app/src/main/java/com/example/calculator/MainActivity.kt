package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etOperand1: EditText = findViewById(R.id.etOperand1)
        val etOperand2: EditText = findViewById(R.id.etOperand2)
        val rgOperation: RadioGroup = findViewById(R.id.rgOperation)
        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val tvResult: TextView = findViewById(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val operand1 = etOperand1.text.toString().toDoubleOrNull()
            val operand2 = etOperand2.text.toString().toDoubleOrNull()
            val selectedOperationId = rgOperation.checkedRadioButtonId

            if (operand1 != null && operand2 != null) {
                val result = when (selectedOperationId) {
                    R.id.rbAdd -> operand1 + operand2
                    R.id.rbSubtract -> operand1 - operand2
                    R.id.rbMultiply -> operand1 * operand2
                    R.id.rbDivide -> if (operand2 != 0.0) operand1 / operand2 else null
                    else -> null
                }
                tvResult.text = result?.toString() ?: "Error"
            } else {
                tvResult.text = "Please enter valid numbers"
            }
        }
    }
}

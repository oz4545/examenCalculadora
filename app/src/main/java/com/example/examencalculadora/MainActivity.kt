package com.example.examencalculadora

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var txtCaja: EditText
    private var operacion: String? = null
    private var operando1: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCaja = findViewById(R.id.txtcaja)
    }

    fun numeroPulsado(digito: String) {
        txtCaja.append(digito)
    }

    fun operacionPulsada(operador: Char) {
        operacion = operador.toString()
        operando1 = txtCaja.text.toString().toDoubleOrNull()
        txtCaja.text.clear()
    }

    fun calcularResultado(view: View) {
        val operando2 = txtCaja.text.toString().toDoubleOrNull()
        if (operando1 != null && operando2 != null && operacion != null) {
            val resultado = when (operacion) {
                "+" -> operando1!! + operando2
                "-" -> operando1!! - operando2
                "*" -> operando1!! * operando2
                "/" -> if (operando2 != 0.0) operando1!! / operando2 else Double.NaN
                else -> Double.NaN
            }
            txtCaja.text.clear()
            txtCaja.append(resultado.toString())
            operacion = null
            operando1 = null
        }
    }

    fun bt0(view: View) { numeroPulsado("0") }
    fun bt1(view: View) { numeroPulsado("1") }
    fun bt2(view: View) { numeroPulsado("2") }
    fun bt3(view: View) { numeroPulsado("3") }
    fun bt4(view: View) { numeroPulsado("4") }
    fun bt5(view: View) { numeroPulsado("5") }
    fun bt6(view: View) { numeroPulsado("6") }
    fun bt7(view: View) { numeroPulsado("7") }
    fun bt8(view: View) { numeroPulsado("8") }
    fun bt9(view: View) { numeroPulsado("9") }
    fun btpunt(view: View) { numeroPulsado(".") }

    fun suma(view: View) { operacionPulsada('+') }
    fun resta(view: View) { operacionPulsada('-') }
    fun multiplicacion(view: View) { operacionPulsada('*') }
    fun division(view: View) { operacionPulsada('/') }

    fun borrar(view: View) {
        val texto = txtCaja.text.toString()
        if (texto.isNotEmpty()) {
            txtCaja.setText(texto.substring(0, texto.length - 1))
        }
    }

    fun clear(view: View) {
        txtCaja.text.clear()
        operacion = null
        operando1 = null
    }

    fun off(view: View) {
        finish()
    }
}
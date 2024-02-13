package borbon.emir.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //nada = 0  suma = 1  resta = 2 multi = 3 division = 4
    var operacion: Int =0
    var numero1:Double = 0.0
    var hayPunto:Boolean = false
    lateinit var tv_1:TextView
    lateinit var tv_2:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_1 = findViewById(R.id.tv_1)
        tv_2 = findViewById(R.id.tv_2)
        val btnBorrar:Button = findViewById(R.id.btn_c)
        val btnIgual:Button = findViewById(R.id.btn_igual)

        btnIgual.setOnClickListener{
            var numero2:Double = tv_2.text.toString().toDouble()
            var resp:Double = 0.0
            when(operacion){
                1-> resp = numero1+numero2
                2-> resp = numero1-numero2
                3-> resp = numero1*numero2
                4-> {
                    if(numero2==0.0){
                        tv_2.setText("No se puede dividir entre 0")
                    }else{
                        resp = numero1/numero2
                    }
                }
            }
            if (resp!=0.0){
                tv_2.setText(resp.toString())
            }
            tv_1.setText("")

            btnBorrar.setOnClickListener {
                tv_1.setText("")
                tv_2.setText("")
                numero1=0.0
                operacion=0
            }
        }
    }

    fun presionarDigito(view:View){
        var num2: String = tv_2.text.toString()

        when(view.id){
            R.id.btn_0 -> tv_2.setText(num2+"0")
            R.id.btn_1 -> tv_2.setText(num2+"1")
            R.id.btn_2 -> tv_2.setText(num2+"2")
            R.id.btn_3 -> tv_2.setText(num2+"3")
            R.id.btn_4 -> tv_2.setText(num2+"4")
            R.id.btn_5 -> tv_2.setText(num2+"5")
            R.id.btn_6 -> tv_2.setText(num2+"6")
            R.id.btn_7 -> tv_2.setText(num2+"7")
            R.id.btn_8 -> tv_2.setText(num2+"8")
            R.id.btn_9 -> tv_2.setText(num2+"9")
            R.id.btn_punto -> {
                if (!hayPunto){
                    tv_2.setText(num2+".")
                    hayPunto = true
                }
            }

        }

    }

    fun cliclOperacion(view:View){
        numero1 = tv_2.text.toString().toDouble()
        var num2_Text: String = tv_2.text.toString()
        tv_2.setText("")
        when(view.id){
            R.id.btn_sum -> {
                tv_1.setText(num2_Text+"+")
                operacion=1
            }
            R.id.btn_res -> {
                tv_1.setText(num2_Text+"-")
                operacion=2
            }
            R.id.btn_mult -> {
                tv_1.setText(num2_Text+"*")
                operacion=3
            }
            R.id.btn_div -> {
                tv_1.setText(num2_Text+"/")
                operacion=4
            }
        }
    }
}
package cat.institut.dam.benvinguda

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.Gravity
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val textView = TextView(this).apply {
            textSize = 48f
            gravity = Gravity.CENTER
            
            val mensaje = "¡Hola Mundo!"
            val colores = intArrayOf(
                Color.RED,
                Color.rgb(255, 128, 0), // Naranja
                Color.rgb(200, 200, 0), // Amarillo oscuro
                Color.rgb(0, 150, 0),   // Verde
                Color.BLUE,
                Color.rgb(75, 0, 130),  // Índigo
                Color.rgb(238, 130, 238) // Violeta
            )
            
            val spanBuilder = SpannableStringBuilder()
            for (i in mensaje.indices) {
                val letra = SpannableString(mensaje[i].toString())
                if (mensaje[i] != ' ') {
                    letra.setSpan(ForegroundColorSpan(colores[i % colores.size]), 0, 1, 0)
                }
                spanBuilder.append(letra)
            }
            
            text = spanBuilder
        }

        setContentView(textView)

        ViewCompat.setOnApplyWindowInsetsListener(textView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
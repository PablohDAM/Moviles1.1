package com.example.actev1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.actev1.databinding.ActivityConfirmationBinding

class ConfirmationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recoger datos pasados desde FormActivity
        val name = intent.getStringExtra("extra_name") ?: "(sin nombre)"
        val email = intent.getStringExtra("extra_email") ?: "(sin email)"
        val message = intent.getStringExtra("extra_message") ?: "(sin mensaje)"

        // Mostrar datos en TextViews con etiquetas
        binding.tvConfirmName.text = "Nombre: $name"
        binding.tvConfirmEmail.text = "Correo: $email"
        binding.tvConfirmMessage.text = "Mensaje: $message"

        // Botón de confirmar
        binding.btnConfirm.setOnClickListener {
            // Guardar datos en SharedPreferences
            val prefs = getSharedPreferences("user_data", MODE_PRIVATE)
            with(prefs.edit()) {
                putString("name", name)
                putString("email", email)
                putString("message", message)
                apply()
            }

            Toast.makeText(this, "Datos enviados correctamente", Toast.LENGTH_SHORT).show()

            // Volver a PresentationActivity
            val intent = Intent(this, PresentationActivity::class.java)
            // limpiar la pila para que no vuelva a ConfirmationActivity al pulsar “Atrás”
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish() // Cierra ConfirmationActivity
        }
    }
}

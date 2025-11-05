package com.example.actev1

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.actev1.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val message = binding.etMessage.text.toString().trim()

            var valid = true

            if (name.isEmpty()) {
                binding.etName.error = "Introduce tu nombre"
                valid = false
            }
            if (email.isEmpty()) {
                binding.etEmail.error = "Introduce un correo"
                valid = false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.error = "Formato de correo no válido"
                valid = false
            }
            if (message.isEmpty()) {
                binding.etMessage.error = "Introduce un mensaje"
                valid = false
            }

            if (!valid) {
                Toast.makeText(this, "Corrige los errores", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Enviar datos a ConfirmationActivity usando Intent explícito
            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("extra_name", name)
                putExtra("extra_email", email)
                putExtra("extra_message", message)
            }
            startActivity(intent)
        }
    }
}

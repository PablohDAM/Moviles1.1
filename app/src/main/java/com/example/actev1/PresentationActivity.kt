package com.example.actev1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.actev1.databinding.ActivityPresentationBinding

class PresentationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPresentationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPresentationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Información personal simulada
        binding.tvName.text = "María Pérez"
        binding.tvAge.text = "Edad: 28"
        binding.tvDescription.text = "Desarrolladora Android en formación. Apasionada por UX y Kotlin."

        binding.btnFormulario.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }
    }
}

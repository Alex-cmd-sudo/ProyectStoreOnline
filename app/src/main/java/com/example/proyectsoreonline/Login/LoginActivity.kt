package com.example.proyectsoreonline.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectsoreonline.R
import com.example.proyectsoreonline.Registro.fragment.Login
import demo.fuzzerrat.equipo1tiendaenlinea.ejemploconsumoservicio.presentation.fragment.ProductosFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if (savedInstanceState == null)
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.root_layout,
                    Login(), Login.TAG
                )
                .commit()
    }
}
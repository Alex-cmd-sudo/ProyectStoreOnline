package com.example.proyectsoreonline.Productos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectsoreonline.R
import demo.fuzzerrat.equipo1tiendaenlinea.ejemploconsumoservicio.presentation.fragment.ProductosFragment

class Productos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        if (savedInstanceState == null)
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.root_layout,
                    ProductosFragment(), ProductosFragment.TAG
                )
                .commit()

    }
}

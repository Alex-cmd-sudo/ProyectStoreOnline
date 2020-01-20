package com.example.proyectsoreonline.Domicilio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectsoreonline.Domicilio.fragment.DomicilioFragment
import com.example.proyectsoreonline.Productos.fragment.ProductosFragment
import com.example.proyectsoreonline.R

class DomicilioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_domicilio)

        if (savedInstanceState == null)
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.root_domicilio,
                    DomicilioFragment(), ProductosFragment.TAG
                )
                .commit()




    }
}

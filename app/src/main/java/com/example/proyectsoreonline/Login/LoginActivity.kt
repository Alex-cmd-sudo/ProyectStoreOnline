package com.example.proyectsoreonline.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectsoreonline.Productos.fragment.ProductosFragment
import com.example.proyectsoreonline.R
import com.example.proyectsoreonline.Registro.fragment.Login

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
    override fun onBackPressed() {
        var canBack = true
        val fragment = supportFragmentManager.findFragmentById(R.id.root_layout)

        if (fragment is ProductosFragment)
            canBack = false

        if (canBack)
            super.onBackPressed()
    }
}

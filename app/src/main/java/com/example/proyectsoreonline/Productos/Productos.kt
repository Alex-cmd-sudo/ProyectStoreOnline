package com.example.proyectsoreonline.Productos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectsoreonline.Carrito.fragment.CarritoFragment
import com.example.proyectsoreonline.R
import com.example.proyectsoreonline.Productos.fragment.ProductosFragment
import kotlinx.android.synthetic.main.main_toolbar.*

class Productos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        if (savedInstanceState == null)
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.productos_root,
                    ProductosFragment(), ProductosFragment.TAG
                )
                .commit()




        ic_carrito.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.productos_root,
                    CarritoFragment(), CarritoFragment.TAG
                )
                .addToBackStack(ProductosFragment.TAG)
                .commit()
        }

    }



    override fun onBackPressed() {
        var canBack = true
        val fragment = supportFragmentManager.findFragmentById(R.id.productos_root)

        if (fragment is ProductosFragment)
            canBack = false

        if (canBack)
            super.onBackPressed()
    }


}

package com.example.proyectsoreonline.Registro

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectsoreonline.Domicilio.DomicilioActivity
import com.example.proyectsoreonline.Domicilio.fragment.DomicilioFragment
import com.example.proyectsoreonline.R
import com.example.proyectsoreonline.Registro.fragment.Formulario
import com.example.proyectsoreonline.Registro.fragment.Login
import demo.fuzzerrat.equipo1tiendaenlinea.ejemploconsumoservicio.presentation.fragment.ProductosFragment


class RegistroActivity : AppCompatActivity() , Login.LoginCallBacks, Formulario.FormularioCallBacks, ProductosFragment.ProductosCallBacks {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        window.decorView.apply {
//            // Hide both the navigation bar and the status bar.
//            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
//            // a general rule, you should design your app to hide the status bar whenever you
//            // hide the navigation bar.
//            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
//        }



        /*  if (savedInstanceState == null)
            supportFragmentManager.beginTransaction().add(R.id.fragment_formulario,
            Formulario(),Formulario.TAG).commit()

    }*/


        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()


        val fragment = Login()
        fragmentTransaction.replace(R.id.contenedor, fragment)
        fragmentTransaction.addToBackStack("Login")
        fragmentTransaction.commit()

    }


    override fun callFragmentRegistro() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()


        val fragment = Formulario()
        fragmentTransaction.replace(R.id.contenedor, fragment)
        //fragmentTransaction.addToBackStack("Formulario")
        fragmentTransaction.commit()
    }


    override fun callFragmentLogin() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()


        val fragment = Login()
        fragmentTransaction.replace(R.id.contenedor, fragment)
        fragmentTransaction.addToBackStack("Login")
        fragmentTransaction.commit()
    }

    override fun callFragmentProductos() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()


        val fragment = ProductosFragment()
        fragmentTransaction.replace(R.id.contenedor, fragment)
        fragmentTransaction.addToBackStack("Productos")
        fragmentTransaction.commit()
    }

    fun callFragmentDomicilio() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()


        val fragment = DomicilioFragment()
        fragmentTransaction.replace(R.id.contenedor, fragment)
        fragmentTransaction.addToBackStack("Domicilio")
        fragmentTransaction.commit()
    }


    override fun tomarFotografia() {

    }


}

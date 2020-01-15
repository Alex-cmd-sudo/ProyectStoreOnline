package com.example.proyectsoreonline.Domicilio.fragment


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectsoreonline.Domicilio.presentation.presenter.RegistroDomicilioPresenter
import com.example.proyectsoreonline.Domicilio.presentation.view.DomicilioView

import com.example.proyectsoreonline.R
import com.example.proyectsoreonline.Registro.fragment.Formulario
import net.grandcentrix.thirtyinch.TiFragment

/**
 * A simple [Fragment] subclass.
 */
open class DomicilioFragment : TiFragment<RegistroDomicilioPresenter, DomicilioView>(), DomicilioView {

    var mCallback : DomicilioCallBacks?=  null

    @SuppressLint("MissingSuperCall")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_domicilio, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            mCallback = activity as DomicilioCallBacks
        }
        catch (e:Exception){}


    }

    interface DomicilioCallBacks {
        fun callFragmentDomicilio() {}
    }

    override fun providePresenter(): RegistroDomicilioPresenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mostrarResultadoDeDomicilio(descripcion: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}


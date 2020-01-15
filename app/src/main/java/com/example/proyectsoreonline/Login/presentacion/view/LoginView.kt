package com.example.proyectsoreonline.Registro.presentacion.view

import net.grandcentrix.thirtyinch.TiView

interface LoginView : TiView {
    fun mostrarResultadoDeLogin(descripcion:String)
    fun mostrarCodigoLogin(codigo:String)
}
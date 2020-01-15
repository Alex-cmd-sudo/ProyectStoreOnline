package com.example.proyectsoreonline.Registro.presentacion.view

import net.grandcentrix.thirtyinch.TiView

interface RegistroView : TiView {
    fun mostrarResultadoDeRegistro(descripcion:String)
    fun mostrarResultadoRegistro(codigo:String)
}
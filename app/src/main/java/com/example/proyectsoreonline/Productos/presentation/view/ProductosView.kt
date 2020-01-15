package com.example.proyectsoreonline.Productos.presentation.view

import com.example.proyectsoreonline.Productos.data.model.Productoss
import net.grandcentrix.thirtyinch.TiView

interface ProductosView :TiView{
    fun mostrarProductosObtenidos(articles: List<Productoss>)
    fun showProgress()
    fun hideProgress()

}
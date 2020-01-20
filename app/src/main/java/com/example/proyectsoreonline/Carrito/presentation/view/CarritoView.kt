package com.example.proyectsoreonline.Carrito.presentation.view

import com.example.proyectsoreonline.Productos.data.model.Productoss
import net.grandcentrix.thirtyinch.TiView

interface CarritoView:TiView {
    fun productosDesdeStoreService(articlesFromStoreService: List<Productoss>)
   // fun mostrarResultadoCarrito(descripcion:String)
    //fun error(descripcion: String)
}
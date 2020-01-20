package com.example.proyectsoreonline.Carrito.domain

import com.example.proyectsoreonline.Carrito.data.model.CarritoRequest
import com.example.proyectsoreonline.Carrito.data.model.CarritoResponse
import com.example.proyectsoreonline.Login.data.model.LoginUsuarioResponse
import rx.Observable

interface CarritoInteractor {

    fun listaCarrito(
        nombre: String,
        cantidad: Int,
        subtotal: Int,
        total: String
    ): Observable<CarritoResponse>
}
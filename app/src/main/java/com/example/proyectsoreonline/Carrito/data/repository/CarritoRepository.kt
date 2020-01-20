package com.example.proyectsoreonline.Carrito.data.repository

import com.example.proyectsoreonline.Carrito.data.model.CarritoRequest
import com.example.proyectsoreonline.Carrito.data.model.CarritoResponse
import com.example.proyectsoreonline.Login.data.model.LoginUsuarioRequest
import com.example.proyectsoreonline.Login.data.model.LoginUsuarioResponse
import net.grandcentrix.thirtyinch.TiView
import rx.Observable

interface CarritoRepository {
    fun listaCarrito(reqest: CarritoRequest): Observable<CarritoResponse>
}
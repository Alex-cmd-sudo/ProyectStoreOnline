package com.example.proyectsoreonline.Carrito.data.repository

import com.example.proyectsoreonline.Carrito.data.model.CarritoRequest
import com.example.proyectsoreonline.Carrito.data.model.CarritoResponse
import com.example.proyectsoreonline.Carrito.data.service.CarritoApiService
import rx.Observable

class CarritoRepositoryImpl:CarritoRepository {

    var carritoService : CarritoApiService?=null

    init{
        carritoService = CarritoApiService.Builder().build()
    }


    override fun listaCarrito(reqest: CarritoRequest): Observable<CarritoResponse> {
        return carritoService!!.listaCarrito(reqest)
    }


}
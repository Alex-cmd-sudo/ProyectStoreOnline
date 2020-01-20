package com.example.proyectsoreonline.Carrito.domain

import com.example.proyectsoreonline.Carrito.data.model.CarritoRequest
import com.example.proyectsoreonline.Carrito.data.model.CarritoResponse
import com.example.proyectsoreonline.Carrito.data.repository.CarritoRepository
import com.example.proyectsoreonline.Carrito.data.repository.CarritoRepositoryImpl
import rx.Observable

class CarritoInteractorImpl:CarritoInteractor {

    var carritoRepository: CarritoRepository? = null

    init {
        carritoRepository = CarritoRepositoryImpl()
    }

    override fun listaCarrito(
        nombre: String,
        cantidad: Int,
        subtotal:Int,
        total:String

    ): Observable<CarritoResponse> {


        var request  = CarritoRequest()
            .withNombre(nombre)
            .withCantidad(cantidad)
            .withSub(subtotal)
            .withTotal(total)


        return carritoRepository!!.listaCarrito(request)
    }

}
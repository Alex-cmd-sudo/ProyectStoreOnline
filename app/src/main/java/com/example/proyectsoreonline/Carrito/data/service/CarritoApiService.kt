package com.example.proyectsoreonline.Carrito.data.service

import com.example.proyectsoreonline.Carrito.data.model.CarritoRequest
import com.example.proyectsoreonline.Carrito.data.model.CarritoResponse
import com.example.proyectsoreonline.utils.BaseServiceBuilder
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import rx.Observable

interface CarritoApiService {

    // @Headers("Content-Type:text/plain; charset=UTF-8")
    @Headers("Content-Type:text/plain")
    @POST("compra")
    fun listaCarrito(@Body request : CarritoRequest) : Observable<CarritoResponse>

    class Builder : BaseServiceBuilder<CarritoApiService>(){
        override fun build(): CarritoApiService {
            return mBuilder.build().create(CarritoApiService::class.java)
        }

    }

}

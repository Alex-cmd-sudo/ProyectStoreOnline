package com.example.proyectsoreonline.Tarjeta.data.service

import com.example.proyectsoreonline.Tarjeta.data.model.RegistroTarjetaRequest
import com.example.proyectsoreonline.Tarjeta.data.model.RegistroTarjetaResponse
import com.example.proyectsoreonline.utils.BaseServiceBuilder
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import rx.Observable

interface TarjetaApiService {

    // @Headers("Content-Type:text/plain; charset=UTF-8")
    @Headers("Content-Type:text/plain")
    @POST("agregarTarjeta")

    fun registroTarjeta(@Body request : RegistroTarjetaRequest) : Observable<RegistroTarjetaResponse>


    class Builder : BaseServiceBuilder<TarjetaApiService>(){
        override fun build(): TarjetaApiService {
            return mBuilder.build().create(TarjetaApiService::class.java)
        }

    }
}
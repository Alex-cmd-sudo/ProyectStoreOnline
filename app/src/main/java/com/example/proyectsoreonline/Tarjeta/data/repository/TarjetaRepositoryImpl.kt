package com.example.proyectsoreonline.Tarjeta.data.repository

import com.example.proyectsoreonline.Tarjeta.data.model.RegistroTarjetaResponse
import com.example.proyectsoreonline.Tarjeta.data.model.RegistroTarjetaRequest
import com.example.proyectsoreonline.Tarjeta.data.service.TarjetaApiService
import rx.Observable

class TarjetaRepositoryImpl : TarjetaRepository{

    var apiService : TarjetaApiService?=null

    init {
        apiService = TarjetaApiService.Builder().build()
    }

    override fun registroTarjeta( reqest: RegistroTarjetaRequest): Observable<RegistroTarjetaResponse> {
        return apiService!!.registroTarjeta(reqest)
    }
}
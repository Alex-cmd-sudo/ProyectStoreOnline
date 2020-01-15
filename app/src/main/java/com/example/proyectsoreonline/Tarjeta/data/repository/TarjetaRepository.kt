package com.example.proyectsoreonline.Tarjeta.data.repository

import com.example.proyectsoreonline.Tarjeta.data.model.RegistroTarjetaResponse
import com.example.proyectsoreonline.Tarjeta.data.model.RegistroTarjetaRequest
import rx.Observable

interface TarjetaRepository {

    fun registroTarjeta(reqest: RegistroTarjetaRequest): Observable<RegistroTarjetaResponse>
}
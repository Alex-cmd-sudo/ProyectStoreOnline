package com.example.proyectsoreonline.Tarjeta.domain

import com.example.proyectsoreonline.Tarjeta.data.model.RegistroTarjetaResponse
import rx.Observable

interface TarjetaInteractor {

    fun registroTarjeta(numeroTarjeta: String, vigencia: String, cvv: String, titular: String) : Observable<RegistroTarjetaResponse>
}
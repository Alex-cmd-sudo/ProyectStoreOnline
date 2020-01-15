package com.example.proyectsoreonline.Tarjeta.domain

import com.example.proyectsoreonline.Tarjeta.data.model.RegistroTarjetaResponse
import com.example.proyectsoreonline.Tarjeta.data.repository.TarjetaRepository
import com.example.proyectsoreonline.Tarjeta.data.repository.TarjetaRepositoryImpl
import com.example.proyectsoreonline.Tarjeta.data.model.RegistroTarjetaRequest
import rx.Observable

class TarjetaInteractorImpl:TarjetaInteractor {

    var tarjetaRepository: TarjetaRepository? = null

    init {
        tarjetaRepository = TarjetaRepositoryImpl()
    }

    override fun registroTarjeta(
        numeroTarjeta: String,
        vigencia: String,
        cvv: String,
        titular: String
    ): Observable<RegistroTarjetaResponse>{


        var request  = RegistroTarjetaRequest()
            .withNumero(numeroTarjeta)
            .withVigencia(vigencia)
            .withCVV(cvv)
            .withTitular(titular)



        return tarjetaRepository!!.registroTarjeta(request)
    }
}
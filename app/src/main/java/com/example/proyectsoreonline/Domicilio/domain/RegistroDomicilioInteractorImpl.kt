package com.example.proyectsoreonline.Domicilio.domain

import com.example.proyectsoreonline.Domicilio.data.model.RegistroDomicilioRequest
import com.example.proyectsoreonline.Domicilio.data.model.RegistroDomicilioResponse
import com.example.proyectsoreonline.Domicilio.data.repository.RegistroDomicilioRepositoryImpl
import rx.Observable

class RegistroDomicilioInteractorImpl : RegistroDomicilioInteractor {

    var domicilioReposito : RegistroDomicilioRepository? = null

    init {
        domicilioReposito = RegistroDomicilioRepositoryImpl()
    }

    override fun registroDomicilio(
        calle:String,
        numeroExterior:String,
        numeroInterior:String,
        codigoPostal:String,
        municipio:String,
        colonia:String,
        ciudad:String
    ): Observable<RegistroDomicilioResponse>{

        var request = RegistroDomicilioRequest()
            .withCalle(calle)
            .withNumI(numeroInterior)
            .withNumE(numeroExterior)
            .withCP(codigoPostal)
            .withMUnicipio(municipio)
            .withColonia(colonia)
            .withCiudad(ciudad)

        return domicilioReposito!!.registroDomicilio(request)

    }
}

package com.example.proyectsoreonline.Domicilio.domain

import com.example.proyectsoreonline.Domicilio.data.model.RegistroDomicilioResponse
import rx.Observable

interface RegistroDomicilioInteractor {
    fun registroDomicilio(calle:String,
                          numeroExterior:String,
                          numeroInterior:String,
                          codigoPostal:String,
                          municipio:String,
                          colonia:String,
                          ciudad:String
                          ): Observable <RegistroDomicilioResponse>
}
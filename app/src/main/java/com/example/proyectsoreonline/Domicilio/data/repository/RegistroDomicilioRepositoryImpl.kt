package com.example.proyectsoreonline.Domicilio.data.repository

import com.example.proyectsoreonline.Domicilio.data.model.RegistroDomicilioResponse
import com.example.proyectsoreonline.Domicilio.data.model.RegistroDomicilioRequest
import com.example.proyectsoreonline.Domicilio.domain.RegistroDomicilioApiService
import com.example.proyectsoreonline.Domicilio.domain.RegistroDomicilioRepository
import rx.Observable

class RegistroDomicilioRepositoryImpl:RegistroDomicilioRepository {

    var apiService : RegistroDomicilioApiService?=null

    init {
        apiService = RegistroDomicilioApiService.Builder().build()
    }

    override fun registroDomicilio(request: RegistroDomicilioRequest): Observable<RegistroDomicilioResponse> {
        return apiService!!.registrarDomicilio(request)
    }

}
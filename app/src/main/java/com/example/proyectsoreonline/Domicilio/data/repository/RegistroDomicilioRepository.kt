package com.example.proyectsoreonline.Domicilio.domain

import com.example.proyectsoreonline.Domicilio.data.model.RegistroDomicilioResponse
import com.example.proyectsoreonline.Domicilio.data.model.RegistroDomicilioRequest
import rx.Observable
import java.util.*

interface RegistroDomicilioRepository {
    fun registroDomicilio(request: RegistroDomicilioRequest): Observable<RegistroDomicilioResponse>

}

package com.example.proyectsoreonline.Domicilio.domain

import com.example.proyectsoreonline.Domicilio.data.model.RegistroDomicilioResponse
import com.example.proyectsoreonline.Domicilio.data.model.RegistroDomicilioRequest
import com.example.proyectsoreonline.utils.BaseServiceBuilder
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import rx.Observable
import java.util.*

interface RegistroDomicilioApiService {

    @Headers("Content-Type:text/plain")
    @POST("registrarDomicilio")

    fun registrarDomicilio(@Body request : RegistroDomicilioRequest) : Observable<RegistroDomicilioResponse>

    class Builder : BaseServiceBuilder<RegistroDomicilioApiService>(){
        override fun build(): RegistroDomicilioApiService {
            return mBuilder.build().create(RegistroDomicilioApiService::class.java)
        }
    }


}

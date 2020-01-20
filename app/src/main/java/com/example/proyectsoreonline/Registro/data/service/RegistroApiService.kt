package com.example.proyectsoreonline.Registro.data.service

import com.example.proyectsoreonline.utils.BaseServiceBuilder
import com.example.proyectsoreonline.Registro.data.model.RegistroUsuarioRequest
import com.example.proyectsoreonline.Registro.data.model.RegistroUsuarioResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import rx.Observable

interface RegistroApiService {

    // @Headers("Content-Type:text/plain; charset=UTF-8")
    @Headers("Content-Type:text/plain")
    @POST("registrarCliente")
    fun registroUsuario(@Body request : RegistroUsuarioRequest) : Observable<RegistroUsuarioResponse>


    class Builder : BaseServiceBuilder<RegistroApiService>(){
        override fun build(): RegistroApiService {
            return mBuilder.build().create(RegistroApiService::class.java)
        }

    }
}

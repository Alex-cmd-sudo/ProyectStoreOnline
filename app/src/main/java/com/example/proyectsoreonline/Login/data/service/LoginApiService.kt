package com.example.proyectsoreonline.Registro.data.service

import com.example.proyectsoreonline.utils.BaseServiceBuilder
import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.model.LoginUsuarioRequest
import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.model.LoginUsuarioResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import rx.Observable

interface LoginApiService {

    // @Headers("Content-Type:text/plain; charset=UTF-8")
    @Headers("Content-Type:text/plain")
    @POST("iniciarSesionCliente")

    fun loginUsuario(@Body request : LoginUsuarioRequest) : Observable<LoginUsuarioResponse>


    class Builder : BaseServiceBuilder<LoginApiService>(){
        override fun build(): LoginApiService {
            return mBuilder.build().create(LoginApiService::class.java)
        }

    }
}

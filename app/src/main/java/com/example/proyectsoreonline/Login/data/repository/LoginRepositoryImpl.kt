package com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.repository

import com.example.proyectsoreonline.Registro.data.service.LoginApiService
import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.model.LoginUsuarioRequest
import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.model.LoginUsuarioResponse
import rx.Observable

class LoginRepositoryImpl : LoginRepository {

    var apiService : LoginApiService?=null
    init {
        apiService = LoginApiService.Builder().build()
    }

    override fun loginUsuario( request: LoginUsuarioRequest ): Observable<LoginUsuarioResponse> {
        return apiService!!.loginUsuario(request)
    }
}
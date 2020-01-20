package com.example.proyectsoreonline.Login.data.repository

import com.example.proyectsoreonline.Registro.data.service.LoginApiService
import com.example.proyectsoreonline.Login.data.model.LoginUsuarioRequest
import com.example.proyectsoreonline.Login.data.model.LoginUsuarioResponse
import rx.Observable

class LoginRepositoryImpl : LoginRepository {

    var apiService : LoginApiService?=null
    init {
        apiService = LoginApiService.Builder().build()
    }

    override fun loginUsuario( request: LoginUsuarioRequest): Observable<LoginUsuarioResponse> {
        return apiService!!.loginUsuario(request)
    }
}
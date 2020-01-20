package com.example.proyectsoreonline.Login.data.repository

import com.example.proyectsoreonline.Login.data.model.LoginUsuarioRequest
import com.example.proyectsoreonline.Login.data.model.LoginUsuarioResponse
import rx.Observable

interface LoginRepository {
    fun loginUsuario(reqest: LoginUsuarioRequest): Observable<LoginUsuarioResponse>
}
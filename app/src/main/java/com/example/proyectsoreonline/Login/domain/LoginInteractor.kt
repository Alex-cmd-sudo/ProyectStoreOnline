package com.example.proyectsoreonline.Registro.domain

import com.example.proyectsoreonline.Login.data.model.LoginUsuarioResponse
import rx.Observable

interface LoginInteractor {
    fun loginUsuario(email: String,pass:String) : Observable<LoginUsuarioResponse>
}
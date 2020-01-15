package com.example.proyectsoreonline.Registro.domain

import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.model.LoginUsuarioResponse
import rx.Observable

interface LoginInteractor {
    fun loginUsuario(email: String,pass:String) : Observable<LoginUsuarioResponse>
}
package com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.repository

import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.model.LoginUsuarioRequest
import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.model.LoginUsuarioResponse
import rx.Observable

interface LoginRepository {
    fun loginUsuario(reqest: LoginUsuarioRequest): Observable<LoginUsuarioResponse>
}
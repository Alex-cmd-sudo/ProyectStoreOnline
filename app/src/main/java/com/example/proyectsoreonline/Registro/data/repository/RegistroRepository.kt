package com.example.proyectsoreonline.Registro.data.repository

import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.model.RegistroUsuarioRequest
import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.model.RegistroUsuarioResponse
import rx.Observable

interface RegistroRepository {
    fun registroUsuario(reqest: RegistroUsuarioRequest): Observable<RegistroUsuarioResponse>
}
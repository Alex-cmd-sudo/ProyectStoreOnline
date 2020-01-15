package com.example.proyectsoreonline.Registro.data.repository

import com.example.proyectsoreonline.Registro.data.service.RegistroApiService
import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.model.RegistroUsuarioRequest
import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.model.RegistroUsuarioResponse
import rx.Observable

class RegistroRepositoryImpl : RegistroRepository {

    var apiService : RegistroApiService?=null

    init {
        apiService = RegistroApiService.Builder().build()
    }

    override fun registroUsuario( reqest: RegistroUsuarioRequest): Observable<RegistroUsuarioResponse> {
        return apiService!!.registroUsuario(reqest)
    }
}
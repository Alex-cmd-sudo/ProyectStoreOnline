package com.example.proyectsoreonline.Registro.data.repository

import com.example.proyectsoreonline.Registro.data.service.RegistroApiService
import com.example.proyectsoreonline.Registro.data.model.RegistroUsuarioRequest
import com.example.proyectsoreonline.Registro.data.model.RegistroUsuarioResponse
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
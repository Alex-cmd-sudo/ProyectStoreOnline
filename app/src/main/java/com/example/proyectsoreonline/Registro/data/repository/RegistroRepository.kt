package com.example.proyectsoreonline.Registro.data.repository

import com.example.proyectsoreonline.Registro.data.model.RegistroUsuarioRequest
import com.example.proyectsoreonline.Registro.data.model.RegistroUsuarioResponse
import rx.Observable

interface RegistroRepository {
    fun registroUsuario(reqest: RegistroUsuarioRequest): Observable<RegistroUsuarioResponse>
}
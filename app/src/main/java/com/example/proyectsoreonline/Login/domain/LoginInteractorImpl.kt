package com.example.proyectsoreonline.Registro.domain

import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.model.LoginUsuarioRequest
import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.model.LoginUsuarioResponse
import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.repository.LoginRepository
import com.semillero.bancoazteca.equipo2tiendaenlinea.registro.data.repository.LoginRepositoryImpl
import rx.Observable

class LoginInteractorImpl : LoginInteractor{


    var registroRepository: LoginRepository? = null

    init {
        registroRepository = LoginRepositoryImpl()
    }

    override fun loginUsuario(

        email: String,
        pass: String
    ): Observable<LoginUsuarioResponse> {


        var request  = LoginUsuarioRequest()
            .withEmail(email)
            .withPass(pass)

        return registroRepository!!.loginUsuario(request)
    }
}
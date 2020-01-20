package com.example.proyectsoreonline.Registro.domain

import com.example.proyectsoreonline.Login.data.model.LoginUsuarioRequest
import com.example.proyectsoreonline.Login.data.model.LoginUsuarioResponse
import com.example.proyectsoreonline.Login.data.repository.LoginRepository
import com.example.proyectsoreonline.Login.data.repository.LoginRepositoryImpl
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
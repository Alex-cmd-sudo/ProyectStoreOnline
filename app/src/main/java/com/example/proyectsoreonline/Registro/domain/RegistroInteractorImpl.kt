package com.example.proyectsoreonline.Registro.domain


import com.example.proyectsoreonline.Registro.data.model.RegistroUsuarioRequest
import com.example.proyectsoreonline.Registro.data.model.RegistroUsuarioResponse
import com.example.proyectsoreonline.Registro.data.repository.RegistroRepository
import com.example.proyectsoreonline.Registro.data.repository.RegistroRepositoryImpl
import rx.Observable

class RegistroInteractorImpl : RegistroInteractor{


    var domicilioRepository: RegistroRepository? = null

    init {
        domicilioRepository = RegistroRepositoryImpl()
    }

    override fun registroUsuario(
        nombre: String,
        ap: String,
        am: String,
        email: String,
        pass: String,
        anverso:String,
        reverso:String,
        ide:String

    ): Observable<RegistroUsuarioResponse> {


        var request  = RegistroUsuarioRequest()
            .withNombre(nombre)
            .withAp(ap)
            .withAm(am)
            .withEmail(email)
            .withPass(pass)
            .withFotoA(anverso)
            .withFotoR(reverso)
            .withIDE(ide)

        return domicilioRepository!!.registroUsuario(request)
    }
}
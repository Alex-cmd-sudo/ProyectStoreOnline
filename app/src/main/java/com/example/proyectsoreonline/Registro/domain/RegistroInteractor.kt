package com.example.proyectsoreonline.Registro.domain



import com.example.proyectsoreonline.Registro.data.model.RegistroUsuarioResponse
import rx.Observable

interface RegistroInteractor {
    fun registroUsuario(nombre: String, ap: String, am: String, email: String,pass:String,anverso:String,reverso:String,ide:String) : Observable<RegistroUsuarioResponse>
}
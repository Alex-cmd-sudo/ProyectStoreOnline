package com.example.proyectsoreonline.Login.data.model

import com.google.gson.annotations.SerializedName



class LoginUsuarioResponse {

    @SerializedName("msj")

    private var msj: String? = null

    @SerializedName("codigoOperacion")

    private var codigoOperacion: String? = null

    fun getCodigoOperacion(): String? {
        return codigoOperacion
    }

    fun setCodigoOperacion(codigoOperacion: String) {
        this.codigoOperacion = codigoOperacion
    }

    fun withCodigoOperacion(codigoOperacion: String): LoginUsuarioResponse {
        this.codigoOperacion = codigoOperacion
        return this
    }

    fun getMsj(): String? {
        return msj
    }

    fun setMsj(msj: String) {
        this.msj = msj
    }

    fun withMsj(msj: String): LoginUsuarioResponse {
        this.msj = msj
        return this
    }
}
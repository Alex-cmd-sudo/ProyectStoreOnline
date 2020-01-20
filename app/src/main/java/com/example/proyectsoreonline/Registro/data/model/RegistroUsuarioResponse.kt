package com.example.proyectsoreonline.Registro.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class RegistroUsuarioResponse {

    @SerializedName("msj")
    @Expose
    private var msj: String? = null

    @SerializedName("codigoOperacion")
    @Expose
    private var codigoOperacion: String? = null

    fun getCodigoOperacion(): String? {
        return codigoOperacion
    }

    fun setCodigoOperacion(codigoOperacion: String) {
        this.codigoOperacion = codigoOperacion
    }

    fun withCodigoOperacion(codigoOperacion: String): RegistroUsuarioResponse {
        this.codigoOperacion = codigoOperacion
        return this
    }

    fun getMsj(): String? {
        return msj
    }

    fun setMsj(msj: String) {
        this.msj = msj
    }

    fun withMsj(msj: String): RegistroUsuarioResponse {
        this.msj = msj
        return this
    }
}
package com.example.proyectsoreonline.Domicilio.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegistroDomicilioResponse {

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

    fun withCodigoOperacion(codigoOperacion: String): RegistroDomicilioResponse {
        this.codigoOperacion = codigoOperacion
        return this
    }

    fun getMsj(): String? {
        return msj
    }

    fun setMsj(msj: String) {
        this.msj = msj
    }

    fun withMsj(msj: String): RegistroDomicilioResponse {
        this.msj = msj
        return this
    }

}
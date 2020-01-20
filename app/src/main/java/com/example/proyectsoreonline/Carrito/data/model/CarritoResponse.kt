package com.example.proyectsoreonline.Carrito.data.model

import com.google.gson.annotations.SerializedName

class CarritoResponse {

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

    fun withCodigoOperacion(codigoOperacion: String): CarritoResponse {
        this.codigoOperacion = codigoOperacion
        return this
    }

    fun getMsj(): String? {
        return msj
    }

    fun setMsj(msj: String) {
        this.msj = msj
    }

    fun withMsj(msj: String): CarritoResponse {
        this.msj = msj
        return this
    }
}
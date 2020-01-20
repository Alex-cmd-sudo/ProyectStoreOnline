package com.example.proyectsoreonline.Tarjeta.data.model

import com.google.gson.annotations.SerializedName

class RegistroTarjetaRequest {

    @SerializedName("numeroTarjeta")

    private var numero: String? = null

    @SerializedName("fechaDeVigeciaTarjeta")

    private var vigencia: String? = null

    @SerializedName("cvv")

    private var cvv: String? = null

    @SerializedName("nombreCompletoTitular")

    private var titular: String? = null


    fun getNumero(): String? {
        return numero
    }

    fun setNumero(Numero: String) {
        this.numero= Numero
    }

    fun withNumero(Numero: String): RegistroTarjetaRequest {
        this.numero= Numero
        return this
    }

    fun getVigencia(): String? {
        return vigencia
    }

    fun setVigencia(Vigencia: String) {
        this.vigencia= Vigencia
    }

    fun withVigencia(Vigencia: String): RegistroTarjetaRequest {
        this.vigencia = Vigencia
        return this
    }

    fun getCVV(): String? {
        return cvv
    }

    fun setCVV(CVV: String) {
        this.cvv = CVV
    }

    fun withCVV(CVV: String): RegistroTarjetaRequest {
        this.cvv = CVV
        return this
    }

    fun getTitular(): String? {
        return titular
    }

    fun setTitular(TITULAR: String) {
        this.titular = TITULAR
    }

    fun withTitular(TITULAR: String): RegistroTarjetaRequest {
        this.titular = TITULAR
        return this
    }
}

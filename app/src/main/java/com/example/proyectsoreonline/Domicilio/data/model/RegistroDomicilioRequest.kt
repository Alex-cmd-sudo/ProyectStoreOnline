package com.example.proyectsoreonline.Domicilio.data.model

import com.google.gson.annotations.SerializedName

class RegistroDomicilioRequest {

    @SerializedName("calle")

    private var calle: String? = null


    @SerializedName("numeroInterior")

    private var numeroInterior: String? = null


    @SerializedName("numeroExterior")

    private var numeroExterior: String? = null


    @SerializedName("codigoPostal")

    private var codigopostal: String? = null


    @SerializedName("municipio")

    private var municipio: String? = null


    @SerializedName("colonia")

    private var colonia: String? = null

    @SerializedName("ciudad")

    private var ciudad: String? = null

    fun getCalle(): String? {
        return calle
    }

    fun setCalle(cale: String) {
        this.calle = cale
    }

    fun withCalle(cale: String): RegistroDomicilioRequest {
        this.calle = cale
        return this
    }

    fun getANumI(): String? {
        return numeroInterior
    }

    fun setNumI(numI: String) {
        this.numeroInterior = numI
    }

    fun withNumI(numI: String): RegistroDomicilioRequest {
        this.numeroInterior = numI
        return this
    }

    fun getNumE(): String? {
        return numeroExterior
    }

    fun setNumE(numE: String) {
        this.numeroExterior = numE
    }

    fun withNumE(numE: String): RegistroDomicilioRequest {
        this.numeroExterior = numE
        return this
    }

    fun getCP(): String? {
        return codigopostal
    }

    fun setCP(cp: String) {
        this.codigopostal = cp
    }

    fun withCP(cp: String): RegistroDomicilioRequest {
        this.codigopostal = cp
        return this
    }

    fun getMunicipio(): String? {
        return municipio
    }

    fun setMunicipio(muni: String) {
        this.municipio = muni
    }

    fun withMUnicipio(muni: String): RegistroDomicilioRequest {
        this.municipio = muni
        return this
    }

    fun getColonia(): String? {
        return colonia
    }

    fun setColonia(colo: String) {
        this.colonia = colo
    }

    fun withColonia(colo: String): RegistroDomicilioRequest {
        this.colonia = colo
        return this
    }

    fun getCiudad(): String? {
        return ciudad
    }

    fun setCiudad(city: String) {
        this.ciudad = city
    }

    fun withCiudad(city: String): RegistroDomicilioRequest {
        this.ciudad = city
        return this
    }


}

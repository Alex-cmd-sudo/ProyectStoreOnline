package com.example.proyectsoreonline.Registro.data.model

import com.google.gson.annotations.SerializedName

class RegistroUsuarioRequest {

    @SerializedName("nombre")

    private var nombre: String? = null


    @SerializedName("apellidoPaterno")

    private var ap: String? = null


    @SerializedName("apellidoMaterno")

    private var am: String? = null


    @SerializedName("correo")

    private var email: String? = null


    @SerializedName("password")

    private var pass: String? = null


    @SerializedName("identificacionDelantera")

    private var FotoA: String? = null

    @SerializedName("identificacionTrasera")

    private var FotoR: String? = null

    @SerializedName("tipoIdentificacion")

    private var ide: String? = null

    fun getNombre(): String? {
        return nombre
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun withNombre(nombre: String): RegistroUsuarioRequest {
        this.nombre = nombre
        return this
    }

    fun getAp(): String? {
        return ap
    }

    fun setAp(ap: String) {
        this.ap = ap
    }

    fun withAp(ap: String): RegistroUsuarioRequest {
        this.ap = ap
        return this
    }

    fun getAm(): String? {
        return am
    }

    fun setAm(am: String) {
        this.am = am
    }

    fun withAm(am: String): RegistroUsuarioRequest {
        this.am = am
        return this
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun withEmail(email: String): RegistroUsuarioRequest {
        this.email = email
        return this
    }

    fun getFotoA(): String? {
        return FotoA
    }

    fun setFotoA(FotoA: String) {
        this.FotoA = FotoA
    }

    fun withFotoA(FotoA: String): RegistroUsuarioRequest {
        this.FotoA = FotoA
        return this
    }

    fun getFotoR(): String? {
        return FotoR
    }

    fun setFotoR(FotoR: String) {
        this.FotoR = FotoR
    }

    fun withFotoR(FotoR: String): RegistroUsuarioRequest {
        this.FotoR = FotoR
        return this
    }

    fun getPass(): String? {
        return pass
    }

    fun setPass(pass: String) {
        this.pass = pass
    }

    fun withPass(pass: String): RegistroUsuarioRequest {
        this.pass = pass
        return this
    }

    fun getIDE(): String? {
        return ide
    }

    fun setNIDE(ide: String) {
        this.ide = ide
    }

    fun withIDE(ide: String): RegistroUsuarioRequest {
        this.ide = ide
        return this
    }


}
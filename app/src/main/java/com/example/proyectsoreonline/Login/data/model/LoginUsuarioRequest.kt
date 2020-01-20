package com.example.proyectsoreonline.Login.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

import io.realm.annotations.RealmClass

@RealmClass
open class LoginUsuarioRequest :RealmObject(){


     @SerializedName("correo")

    private var email: String? = null


    @SerializedName("password")

    private var pass: String? = null


    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun withEmail(email: String): LoginUsuarioRequest {
        this.email = email
        return this
    }



    fun getPass(): String? {
        return pass
    }

    fun setPass(pass: String) {
        this.pass = pass
    }

    fun withPass(pass: String): LoginUsuarioRequest {
        this.pass = pass
        return this
    }


}
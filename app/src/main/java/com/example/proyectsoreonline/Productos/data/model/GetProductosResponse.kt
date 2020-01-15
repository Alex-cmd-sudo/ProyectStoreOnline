package com.example.proyectsoreonline.Productos.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetProductosResponse {

    @SerializedName("mensaje")
    @Expose
    var mensaje: String? = null
    @SerializedName("codigoOperacion")
    @Expose
    var codigoOperacion: String? = null
    @SerializedName("listaProductos")
    @Expose
    var listaProductos: List<Productoss>? = null

    fun withMensaje(mensaje: String): GetProductosResponse {
        this.mensaje = mensaje
        return this
    }

    fun withCodigoOperacion(codigoOperacion: String): GetProductosResponse {
        this.codigoOperacion = codigoOperacion
        return this
    }

    fun withListaProductos(listaProductos: List<Productoss>): GetProductosResponse {
        this.listaProductos = listaProductos
        return this
    }

}
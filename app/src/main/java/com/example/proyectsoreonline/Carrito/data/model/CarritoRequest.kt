package com.example.proyectsoreonline.Carrito.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CarritoRequest {

    @SerializedName("nombreProducto")
    @Expose
    private var nombreProducto: String? = null


    @SerializedName("cantidadComprada")
    @Expose
    private var cantidadComprada: Int? = null


    @SerializedName("subtotal")
    @Expose
    private var subtotal: Int? = null

    @SerializedName("totalCompra")
    @Expose
    private var totalCompra: String? = null

    fun getNombre(): String? {
        return nombreProducto
    }

    fun setNombre(nombre: String) {
        this.nombreProducto = nombre
    }

    fun withNombre(nombre: String): CarritoRequest {
        this.nombreProducto = nombre
        return this
    }


    fun getCantidad(): Int? {
        return cantidadComprada
    }

    fun setCantidad(cantidad: Int) {
        this.cantidadComprada = cantidad
    }

    fun withCantidad(cantidad: Int): CarritoRequest {
        this.cantidadComprada = cantidad
        return this
    }

    fun getSub(): Int? {
        return subtotal
    }

    fun setSub(subtotal: Int) {
        this.subtotal = subtotal
    }

    fun withSub(subtotal: Int): CarritoRequest {
        this.subtotal = subtotal
        return this
    }


    fun getTotal(): String? {
        return totalCompra
    }

    fun setTotal(total: String) {
        this.totalCompra = total
    }

    fun withTotal(total: String): CarritoRequest {
        this.totalCompra = total
        return this
    }

}
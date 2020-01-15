package com.example.proyectsoreonline.Productos.data.model

import android.content.Intent
import com.google.gson.annotations.SerializedName


class GetProductosRequest {



    @SerializedName("correo", alternate = arrayOf("1"))
    private var mCatalogo: String? = null

    fun getCatalogo(): String? {
        return mCatalogo
    }

    fun withCatalogo(catalogo: String): GetProductosRequest {
        mCatalogo = catalogo
        return this
    }

    fun build(): GetProductosRequest {
        val getArticlesRequest = GetProductosRequest()
        getArticlesRequest.mCatalogo = mCatalogo
        return getArticlesRequest
    }



 /*   @SerializedName("tipoDeporte")

    private var tipoDeporte: String? = null


    @SerializedName("nombreProducto")

    private var nombreProducto: String? = null


    @SerializedName("img")

    private var img: String? = null


    @SerializedName("descripcion")

    private var descripcion: String? = null


    @SerializedName("stock")

    private var stock: Int? = null


    @SerializedName("precio")

    private var precio: Int? = null

    @SerializedName("descuento")

    private var descuento: Int? = null


    fun getDeporte(): String? {
        return tipoDeporte
    }

    fun setDeporte(nombre: String) {
        this.tipoDeporte = nombre
    }

    fun withDeporte(nombre: String): GetProductosRequest {
        this.tipoDeporte = nombre
        return this
    }

    fun getProducto(): String? {
        return nombreProducto
    }

    fun setProducto(ap: String) {
        this.nombreProducto = ap
    }

    fun withProducto(ap: String): GetProductosRequest {
        this.nombreProducto = ap
        return this
    }

    fun getimg(): String? {
        return img
    }

    fun setimg(am: String) {
        this.img = am
    }

    fun withimg(am: String): GetProductosRequest {
        this.img = am
        return this
    }

    fun getdescripcion(): String? {
        return descripcion
    }

    fun setdescripcion(email: String) {
        this.descripcion = email
    }

    fun withdescripcion(email: String): GetProductosRequest {
        this.descripcion = email
        return this
    }

    fun getstock(): Int? {
        return stock
    }

    fun setstock(FotoA: Int) {
        this.stock = FotoA
    }

    fun withstock(FotoA: Int): GetProductosRequest {
        this.stock = FotoA
        return this
    }

    fun getPrecio(): Int? {
        return precio
    }

    fun setPrecio(FotoR: Int) {
        this.precio = FotoR
    }

    fun withPrecio(FotoR: Int): GetProductosRequest {
        this.precio = FotoR
        return this
    }

    fun getDescuento(): Int? {
        return descuento
    }

    fun setDescuento(pass: Int) {
        this.descuento = pass
    }

    fun withDescuento(pass: Int): GetProductosRequest {
        this.descuento = pass
        return this
    }

    fun withProducto(): GetProductosRequest {

        return this
    }

    fun withDeporte(): GetProductosRequest {
        return this
    }

    fun withDescuento(): GetProductosRequest {
        return this
    }

    fun withimg(): GetProductosRequest {
        return this
    }

    fun withstock(): GetProductosRequest {
        return this
    }

    fun withPrecio(): GetProductosRequest {
        return this
    }
*/
}
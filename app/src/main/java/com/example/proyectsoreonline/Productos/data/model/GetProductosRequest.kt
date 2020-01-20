package com.example.proyectsoreonline.Productos.data.model

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
}
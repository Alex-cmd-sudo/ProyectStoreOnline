package com.example.proyectsoreonline.Productos.data.service

import com.example.proyectsoreonline.utils.BaseServiceBuilder
import com.example.proyectsoreonline.Productos.data.model.GetProductosRequest
import com.example.proyectsoreonline.Productos.data.model.GetProductosResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import rx.Observable

interface  ProductosApiService {
    @Headers("Content-Type:text/plain")
    @POST("verProducto")
    fun getArticles(@Body request: GetProductosRequest) : Observable<GetProductosResponse>

    class Builder : BaseServiceBuilder<ProductosApiService>() {
        override fun build(): ProductosApiService {
            return mBuilder.build().create(ProductosApiService::class.java)
        }
    }
}

package com.example.proyectsoreonline.Productos.data.repository;

import com.example.proyectsoreonline.Productos.data.model.GetProductosRequest
import com.example.proyectsoreonline.Productos.data.model.GetProductosResponse
import com.example.proyectsoreonline.Productos.data.repository.ProductosRepository
import com.example.proyectsoreonline.Productos.data.service.ProductosApiService
import rx.Observable


class ProductosRepositoryImpl : ProductosRepository {

    var  apiService: ProductosApiService?=null
    init {
        apiService =  ProductosApiService.Builder().build()
    }


    override fun getProductos(request: GetProductosRequest): Observable<GetProductosResponse> {
        return apiService!!.getArticles(request)
    }
}

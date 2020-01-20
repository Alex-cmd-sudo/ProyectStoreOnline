package com.example.proyectsoreonline.Productos.domain;


import com.example.proyectsoreonline.Productos.data.model.GetProductosResponse
import rx.Observable

interface ProductosInteractor {
    fun getProductos(catalogo:String ): Observable<GetProductosResponse>
}

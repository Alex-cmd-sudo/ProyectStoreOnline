package com.example.proyectsoreonline.Productos.data.repository;

import com.example.proyectsoreonline.Productos.data.model.GetProductosRequest
import com.example.proyectsoreonline.Productos.data.model.GetProductosResponse
import rx.Observable

interface ProductosRepository {
     fun getProductos( request: GetProductosRequest): Observable<GetProductosResponse>
}

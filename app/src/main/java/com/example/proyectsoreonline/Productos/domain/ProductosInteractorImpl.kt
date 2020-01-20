package com.example.proyectsoreonline.Productos.domain;



import com.example.proyectsoreonline.Productos.data.model.GetProductosRequest
import com.example.proyectsoreonline.Productos.data.model.GetProductosResponse
import com.example.proyectsoreonline.Productos.data.repository.ProductosRepository
import com.example.proyectsoreonline.Productos.data.repository.ProductosRepositoryImpl
import com.example.proyectsoreonline.Productos.domain.ProductosInteractor
import rx.Observable

class ProductosInteractorImpl : ProductosInteractor {


//    private static final String APP = "Android-" + Build.VERSION.RELEASE + '-' + BuildConfig.VERSION_CODE;

    var ejemploRepository: ProductosRepository? = null

    init {
        ejemploRepository =  ProductosRepositoryImpl()
    }
    override fun getProductos(catalogo: String): Observable<GetProductosResponse> {
         var request =  GetProductosRequest()
             .withCatalogo(catalogo)
                /*.withDeporte()
                .withProducto()
                .withDescuento()
                .withimg()
                .withstock()
                .withPrecio()*/

        return ejemploRepository!!.getProductos(request)
    }


}

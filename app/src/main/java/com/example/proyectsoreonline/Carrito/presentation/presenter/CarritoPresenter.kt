package com.example.proyectsoreonline.Carrito.presentation.presenter

import com.example.proyectsoreonline.Carrito.domain.CarritoInteractor
import com.example.proyectsoreonline.Carrito.domain.CarritoInteractorImpl
import com.example.proyectsoreonline.Carrito.presentation.view.CarritoView
import com.example.proyectsoreonline.Login.data.model.LoginUsuarioRequest
import com.example.proyectsoreonline.Productos.domain.ProductosInteractor
import com.example.proyectsoreonline.Productos.domain.ProductosInteractorImpl
import io.realm.Realm
import io.realm.kotlin.where
import net.grandcentrix.thirtyinch.TiPresenter
import net.grandcentrix.thirtyinch.rx.RxTiPresenterSubscriptionHandler
import net.grandcentrix.thirtyinch.rx.RxTiPresenterUtils
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class CarritoPresenter: TiPresenter<CarritoView>() {


    private var rxTiPresenterSubscriptionHandler: RxTiPresenterSubscriptionHandler = RxTiPresenterSubscriptionHandler(this)
    private var ejemploInteractor: ProductosInteractor? = null
//    private var registroInteractor: CarritoInteractor?=null


    init {
        ejemploInteractor = ProductosInteractorImpl()
//        registroInteractor = CarritoInteractorImpl()
    }



    private fun getEmailFromDatabase(): String{
        val realm = Realm.getDefaultInstance()
        val person = realm.where<LoginUsuarioRequest>().findFirst()
        if(person != null) { // si es nulo, nunca se logueo y hay que crear un nuevo usuario en base
            return person.getEmail()!!
        }
        return ""
    }


    fun obtenerProductosDesdeStoreService() {
        rxTiPresenterSubscriptionHandler.manageSubscription(ejemploInteractor!!
            .getProductos(getEmailFromDatabase())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxTiPresenterUtils.deliverLatestToView(this))
            .subscribe({ response ->
               // view!!.hideProgress()
                if (response.codigoOperacion == "1")
                    view!!.productosDesdeStoreService(response.listaProductos!!)
            }, { throwable ->
                //view!!.hideProgress()
                println(throwable.message)
            })
        )
    }

}
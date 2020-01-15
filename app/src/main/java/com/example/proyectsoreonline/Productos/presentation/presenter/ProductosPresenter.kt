package com.example.proyectsoreonline.Productos.presentation.presenter

import com.semillero.bancoazteca.equipo2tiendaenlinea.ejemploconsumoservicio.domain.ProductosInteractor
import com.semillero.bancoazteca.equipo2tiendaenlinea.ejemploconsumoservicio.domain.ProductosInteractorImpl
import com.example.proyectsoreonline.Productos.presentation.view.ProductosView
import net.grandcentrix.thirtyinch.TiPresenter
import net.grandcentrix.thirtyinch.rx.RxTiPresenterSubscriptionHandler
import net.grandcentrix.thirtyinch.rx.RxTiPresenterUtils
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ProductosPresenter : TiPresenter<ProductosView>() {
    private var rxTiPresenterSubscriptionHandler: RxTiPresenterSubscriptionHandler = RxTiPresenterSubscriptionHandler(this)
    private var ejemploInteractor: ProductosInteractor? = null

    init {
        ejemploInteractor = ProductosInteractorImpl()
    }

    fun ListaDeArticulos(catalogo:String){


        rxTiPresenterSubscriptionHandler.manageSubscription(ejemploInteractor!!
            .getProductos(catalogo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxTiPresenterUtils.deliverLatestToView(this))
            .subscribe({ response ->
                view!!.hideProgress()
                if (response.codigoOperacion == "1")
                    view!!.mostrarProductosObtenidos(response.listaProductos!!)
            }, { throwable ->
                view!!.hideProgress()
                println(throwable.message)
            })
        )

    }
}
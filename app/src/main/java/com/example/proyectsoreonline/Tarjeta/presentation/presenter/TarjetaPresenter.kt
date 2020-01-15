package com.example.proyectsoreonline.Tarjeta.presentation.presenter

import com.example.proyectsoreonline.Registro.domain.RegistroInteractor
import com.example.proyectsoreonline.Registro.domain.RegistroInteractorImpl
import com.example.proyectsoreonline.Tarjeta.domain.TarjetaInteractor
import com.example.proyectsoreonline.Tarjeta.domain.TarjetaInteractorImpl
import com.example.proyectsoreonline.Tarjeta.presentation.view.TarjetaView
import net.grandcentrix.thirtyinch.TiPresenter
import net.grandcentrix.thirtyinch.rx.RxTiPresenterSubscriptionHandler
import net.grandcentrix.thirtyinch.rx.RxTiPresenterUtils
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class TarjetaPresenter: TiPresenter<TarjetaView>() {

    private var rxTiPresenterSubscriptionHandler: RxTiPresenterSubscriptionHandler = RxTiPresenterSubscriptionHandler(this)

    private var registroInteractor: TarjetaInteractor?=null


    init {
        registroInteractor = TarjetaInteractorImpl()
    }


    fun registroTarjeta(numeroTarjeta: String, vigencia: String, cvv: String, titular: String){


        rxTiPresenterSubscriptionHandler.manageSubscription(registroInteractor!!
            .registroTarjeta(numeroTarjeta, vigencia, cvv, titular)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxTiPresenterUtils.deliverLatestToView(this))
            .subscribe({ response ->
                (response.getCodigoOperacion().equals("1"))

                view!!.mostrarResultadoDeRegistroDeTarjeta(response.getMsj()!!)
            }, { throwable ->
                println(throwable.message)
            }))

    }
}
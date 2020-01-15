package com.example.proyectsoreonline.Domicilio.presentation.presenter

import com.example.proyectsoreonline.Domicilio.domain.RegistroDomicilioInteractor
import com.example.proyectsoreonline.Domicilio.domain.RegistroDomicilioInteractorImpl
import com.example.proyectsoreonline.Domicilio.presentation.view.DomicilioView
import net.grandcentrix.thirtyinch.TiPresenter
import net.grandcentrix.thirtyinch.rx.RxTiPresenterSubscriptionHandler
import net.grandcentrix.thirtyinch.rx.RxTiPresenterUtils
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RegistroDomicilioPresenter : TiPresenter<DomicilioView>(){

    private var rxTiPresenterSubscriptionHandler: RxTiPresenterSubscriptionHandler = RxTiPresenterSubscriptionHandler(this)

    private var registroInteractor: RegistroDomicilioInteractor?=null


    init {
        registroInteractor = RegistroDomicilioInteractorImpl()
    }


    fun registroDomicilio(calle: String, numeroExterior: String, numeroInterior: String, codigoPostal: String, municipio:String,colonia:String,ciudad:String){


        rxTiPresenterSubscriptionHandler.manageSubscription(registroInteractor!!
            .registroDomicilio(calle,numeroExterior,numeroInterior,codigoPostal,municipio,colonia, ciudad)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxTiPresenterUtils.deliverLatestToView(this))
            .subscribe({ response ->
                (response.getCodigoOperacion().equals("1"))


                view!!.mostrarResultadoDeDomicilio(response.getMsj()!!)
            }, { throwable ->
                println(throwable.message)
            }))

    }
}
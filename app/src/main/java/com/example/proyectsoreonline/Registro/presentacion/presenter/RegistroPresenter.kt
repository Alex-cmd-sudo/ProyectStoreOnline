package com.example.proyectsoreonline.Registro.presentacion.presenter

import com.example.proyectsoreonline.Registro.domain.LoginInteractor
import com.example.proyectsoreonline.Registro.domain.LoginInteractorImpl
import com.example.proyectsoreonline.Registro.domain.RegistroInteractor
import com.example.proyectsoreonline.Registro.domain.RegistroInteractorImpl
import com.example.proyectsoreonline.Registro.presentacion.view.LoginView
import com.example.proyectsoreonline.Registro.presentacion.view.RegistroView
import net.grandcentrix.thirtyinch.TiPresenter
import net.grandcentrix.thirtyinch.rx.RxTiPresenterSubscriptionHandler
import net.grandcentrix.thirtyinch.rx.RxTiPresenterUtils
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RegistroPresenter : TiPresenter<RegistroView>() {
    private var rxTiPresenterSubscriptionHandler: RxTiPresenterSubscriptionHandler = RxTiPresenterSubscriptionHandler(this)

    private var registroInteractor: RegistroInteractor?=null


    init {
        registroInteractor = RegistroInteractorImpl()
    }


    fun registroUsuario(nombre: String, ap: String, am: String, email: String, pass:String,anverso:String,reverso:String,ide:String){


        rxTiPresenterSubscriptionHandler.manageSubscription(registroInteractor!!
            .registroUsuario(nombre, ap, am, email, pass,anverso,reverso,ide)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxTiPresenterUtils.deliverLatestToView(this))
            .subscribe({ response ->
                if(response.getCodigoOperacion().equals("1"))
                view!!.mostrarResultadoDeRegistro(response.getMsj()!!)
            }, { throwable ->
                println(throwable.message)
            }))

    }
}
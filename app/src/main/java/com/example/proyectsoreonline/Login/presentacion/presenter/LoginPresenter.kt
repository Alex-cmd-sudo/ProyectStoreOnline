package com.example.proyectsoreonline.Registro.presentacion.presenter

import com.example.proyectsoreonline.Registro.domain.LoginInteractor
import com.example.proyectsoreonline.Registro.domain.LoginInteractorImpl
import com.example.proyectsoreonline.Registro.presentacion.view.LoginView
import net.grandcentrix.thirtyinch.TiPresenter
import net.grandcentrix.thirtyinch.rx.RxTiPresenterSubscriptionHandler
import net.grandcentrix.thirtyinch.rx.RxTiPresenterUtils
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class LoginPresenter : TiPresenter<LoginView>() {
    private var rxTiPresenterSubscriptionHandler: RxTiPresenterSubscriptionHandler = RxTiPresenterSubscriptionHandler(this)

    private var registroInteractor: LoginInteractor?=null


    init {
        registroInteractor = LoginInteractorImpl()
    }


    fun registroUsuario(email: String, pass:String){


        rxTiPresenterSubscriptionHandler.manageSubscription(registroInteractor!!
            .loginUsuario(email, pass)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxTiPresenterUtils.deliverLatestToView(this))
            .subscribe({ response ->
                (response.getCodigoOperacion().equals("1"))
                view!!.mostrarCodigoLogin(response.getCodigoOperacion()!!)
                view!!.mostrarResultadoDeLogin(response.getMsj()!!)
            }, { throwable ->
                println(throwable.message)
            }))

    }
}
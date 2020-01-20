package com.example.proyectsoreonline.Carrito.fragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectsoreonline.Carrito.data.model.ElemtoDeCarrito
import com.example.proyectsoreonline.Carrito.presentation.presenter.CarritoAdapter
import com.example.proyectsoreonline.Carrito.presentation.presenter.CarritoPresenter
import com.example.proyectsoreonline.Carrito.presentation.view.CarritoView
import com.example.proyectsoreonline.Productos.data.model.ListaProductos
import com.example.proyectsoreonline.Productos.data.model.Productoss

import com.example.proyectsoreonline.R
import io.realm.Realm
import io.realm.RealmList
import io.realm.kotlin.where
import net.grandcentrix.thirtyinch.TiFragment

/**
 * A simple [Fragment] subclass.
 */
class CarritoFragment : TiFragment<CarritoPresenter, CarritoView>(), CarritoView, CarritoAdapter.ItemClickListener {

    override fun providePresenter(): CarritoPresenter {
        return CarritoPresenter()
    }

    private lateinit var listaDeCarrito: RealmList<Productoss>
    private var listaElementosDeCarrito: ArrayList<ElemtoDeCarrito> = ArrayList()

    private lateinit var realm: Realm

    @SuppressLint("MissingSuperCall")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carrito, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO verificar elementos del carrito

        listaDeCarrito = obtenerElementosDeCarrito()
        //poblarListaParaVisualizarElResumenDeCarrito(listaDeCarrito)
        //consumir servicio de productos para verificar el stock
        presenter.obtenerProductosDesdeStoreService()
    }


    override fun productosDesdeStoreService(articlesFromStoreService: List<Productoss>) {
        poblarListaParaVisualizarElResumenDeCarrito(listaDeCarrito, articlesFromStoreService)
    }


    private fun obtenerElementosDeCarrito(): RealmList<Productoss> {
        realm = Realm.getDefaultInstance()

        var carrito = realm.where<ListaProductos>().findFirst()
        if (carrito != null) {
            return carrito!!.productos
        }

        return RealmList<Productoss>()
    }

private fun poblarListaParaVisualizarElResumenDeCarrito(listaDeCarrito: RealmList<Productoss>,articlesFromStoreService: List<Productoss>){

        var car = listaDeCarrito.groupBy { it.nombreProducto }

        //TODO checar stock, traerlo de servicios it.value.first().stock

        car.forEach {

            var elemento = ElemtoDeCarrito(
                it.value.first(),
                obtenerDisponibilidadDesdeServidor(it.key!!, articlesFromStoreService),
                it.value.size,
                getTotalPrecioProProducto(it.value))

            listaElementosDeCarrito.add(elemento)

        }


        listaDeCarrito.forEach {
            Log.e("->", it.nombreProducto)
            Log.e("->", it.precio.toString())
        }
        Log.e("---------", "----------")
        //TODO poblar lista
        listaElementosDeCarrito.forEach {

            Log.e("*******", "******")
            Log.e("->", it.producto.nombreProducto)
            Log.e("En carrito:", it.stockEnCarrito.toString())
            Log.e("Disponibles en linea:", it.disponibles.toString())
            Log.e("Precio Total:", it.totalPrecioDeProducto.toString())
        }
    }


    private fun obtenerDisponibilidadDesdeServidor(nameProduct:String, articlesFromStoreService:List<Productoss>):Int{
        return articlesFromStoreService.filter { it.nombreProducto == nameProduct }.single().stock!!
    }

    private fun getTotalPrecioProProducto(l:List<Productoss>):Double{
        var s = 0.0
        l.forEach {
            s += it.precio!!
        }
        return s
    }


    companion object{
        val TAG = CarritoFragment::class.java.simpleName
    }

    override fun onItemClick(view: View, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addToCart(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

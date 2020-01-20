package com.example.proyectsoreonline.Carrito.fragment


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectsoreonline.Carrito.data.model.ElemtoDeCarrito
import com.example.proyectsoreonline.Carrito.presentation.presenter.CarritoAdapter
import com.example.proyectsoreonline.Carrito.presentation.presenter.CarritoPresenter
import com.example.proyectsoreonline.Carrito.presentation.view.CarritoView
import com.example.proyectsoreonline.Domicilio.DomicilioActivity
import com.example.proyectsoreonline.Domicilio.fragment.DomicilioFragment
import com.example.proyectsoreonline.Productos.Productos
import com.example.proyectsoreonline.Productos.data.model.ListaProductos
import com.example.proyectsoreonline.Productos.data.model.Productoss
import com.example.proyectsoreonline.Productos.fragment.ProductosFragment
import com.example.proyectsoreonline.Productos.presentation.presenter.MyAdapter

import com.example.proyectsoreonline.R
import com.example.proyectsoreonline.Registro.fragment.Formulario
import com.example.proyectsoreonline.Registro.fragment.Login
import com.tbruyelle.rxpermissions.RxPermissions
import io.realm.Realm
import io.realm.RealmList
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.fragment_carrito.*
import kotlinx.android.synthetic.main.fragment_ejemplo_consumo.*
import kotlinx.android.synthetic.main.item_list_carrito.*
import net.grandcentrix.thirtyinch.TiFragment

/**
 * A simple [Fragment] subclass.
 */
class CarritoFragment : TiFragment<CarritoPresenter, CarritoView>(), CarritoView, CarritoAdapter.ItemClickListener {

    interface CarritoCallBacks {
         fun callFragmentDomicilio(){

        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mCallback = activity as CarritoCallBacks
        }
        catch (e:Exception){}
    }

    override fun providePresenter(): CarritoPresenter {
        return CarritoPresenter()
    }

    var mCallback : CarritoCallBacks?=  null

    var adaptadorLista: CarritoAdapter? = null



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
        var rxPermission = RxPermissions(activity!!)

        //TODO verificar elementos del carrito
        //presenter.obtenerProductosDesdeStoreService()
        listaDeCarrito = obtenerElementosDeCarrito()

        //pintarElementosLista(ArrayList())
        //poblarListaParaVisualizarElResumenDeCarrito(listaDeCarrito,obtenerElementosDeCarrito())
        //obtenerElementosDeCarrito()

        //poblarListaParaVisualizarElResumenDeCarrito(listaDeCarrito,obtenerElementosDeCarrito())
        //consumir servicio de productos para verificar el stock
        presenter.obtenerProductosDesdeStoreService()
        //obtenerElementosDeCarrito()
//
        btn_pagar.setOnClickListener{

            //mCallback!!.callFragmentDomicilio()
            var intent = Intent(context, DomicilioActivity::class.java)
            startActivity(intent)
            Toast.makeText(context,"equisdeeeeeeeee",Toast.LENGTH_LONG).show()
        }

    }

    fun pintarElementosLista(carrito: ArrayList<ProductosFragment>) {

        adaptadorLista = CarritoAdapter(context!!, carrito)
        adaptadorLista!!.setClickListenerCarrito(this)
        var miManager = LinearLayoutManager(context)
        miRecyclerCarrito.layoutManager = miManager
        miRecyclerCarrito.adapter =adaptadorLista
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

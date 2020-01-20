package com.example.proyectsoreonline.Productos.fragment


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectsoreonline.Productos.data.model.ListaProductos
import com.example.proyectsoreonline.Productos.presentation.presenter.MyAdapter
import com.example.proyectsoreonline.Productos.presentation.view.Listener
import com.example.proyectsoreonline.R
import com.example.proyectsoreonline.Productos.data.model.Productoss
import com.example.proyectsoreonline.Productos.presentation.presenter.ProductosPresenter
import com.example.proyectsoreonline.Productos.presentation.view.ProductosView
import com.example.proyectsoreonline.utils.LoadingDialog
import com.example.proyectsoreonline.Login.data.model.LoginUsuarioRequest
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.fragment_ejemplo_consumo.*
import kotlinx.android.synthetic.main.item_list.*
import net.grandcentrix.thirtyinch.TiFragment
import java.lang.Exception
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 */
class ProductosFragment : TiFragment<ProductosPresenter, ProductosView>(), ProductosView,Listener, MyAdapter.ItemClickListener {

    private var indeterminateDialog: LoadingDialog? = null
    private lateinit var realm: Realm

    var adaptadorLista: MyAdapter? = null


    var mCallback : ProductosCallBacks?=  null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mCallback = activity as ProductosCallBacks
        } catch (e: Exception) {
        }
    }


    override fun providePresenter(): ProductosPresenter {
        return ProductosPresenter()
    }

    @SuppressLint("MissingSuperCall")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ejemplo_consumo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showProgress()
        presenter.ListaDeArticulos(getEmailFromDatabase())

    }

    private fun getEmailFromDatabase(): String{
        val realm = Realm.getDefaultInstance()
        val person = realm.where<LoginUsuarioRequest>().findFirst()
        if(person != null) { // si es nulo, nunca se logueo y hay que crear un nuevo usuario en base
           return person.getEmail()!!
        }
        return ""
    }

     fun pintarElementosLista(lista: ArrayList<Productoss>) {

         adaptadorLista = MyAdapter(context!!, lista)
         adaptadorLista!!.setClickListener(this)
               var miManager = LinearLayoutManager(context)
               miRecycler.layoutManager = miManager
               miRecycler.adapter =adaptadorLista
    }

    companion object{
        val TAG = ProductosFragment::class.java.simpleName
        fun newInstance() = ProductosFragment()
    }

    override fun mostrarProductosObtenidos(productosses: List<Productoss>) {
       pintarElementosLista(ArrayList(productosses))
    }

    interface ProductosCallBacks {
        fun tomarFotografia() {
        }
    }

    override fun cambiarFragment(fragmento: String) {
        Toast.makeText(context,fragmento, Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(context, "You clicked " + adaptadorLista!!.getItem(position).toString() + " on row number " + position, Toast.LENGTH_SHORT).show()
    }


    override fun addToCart(position: Int) {
        Toast.makeText(context, "quieres agregar al carrito " + adaptadorLista!!.getItem(position).nombreProducto , Toast.LENGTH_SHORT).show()
        //TODO hacer logica para guardar en base en la lista del carrito
        guardarProductoEnCarrito(adaptadorLista!!.getItem(position))
    }

    override fun showProgress() {
        if (indeterminateDialog != null) {
            indeterminateDialog!!.dismiss()
        }
        indeterminateDialog = LoadingDialog()
        indeterminateDialog!!.show(fragmentManager!!, null)
    }

    override fun hideProgress() {
        if (indeterminateDialog != null)
            indeterminateDialog!!.dismiss()
    }


    private fun guardarProductoEnCarrito(producto:Productoss){
        //TODO verificar si el carrito existe en base
        realm = Realm.getDefaultInstance()

        realm.executeTransaction {
            var carrito = realm.where<ListaProductos>().findFirst()
            if (carrito == null){//el carrito en base no existe y se tiene que crear

                    carrito = realm.createObject()}


            else { // el carrito existe y se agrega el producto al carrito
                carrito!!.productos.add(objetoProductoRealm(producto))
            }
        }
    }

    private fun objetoProductoRealm(producto: Productoss): Productoss {

        var p:Productoss?=null
      //  realm.executeTransaction {
            p = realm.createObject<Productoss>()
            p!!.descripcion = producto.descripcion
            p!!.descuento = producto.descuento
            p!!.img = producto.img
            p!!.nombreProducto = producto.nombreProducto
            p!!.precio = producto.precio
            p!!.stock = producto.stock
            p!!.tipoDeporte = producto.tipoDeporte
        //}
        return p

    }

}



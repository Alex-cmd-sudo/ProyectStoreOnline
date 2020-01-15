package demo.fuzzerrat.equipo1tiendaenlinea.ejemploconsumoservicio.presentation.fragment


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectsoreonline.Productos.presentation.presenter.MyAdapter
import com.example.proyectsoreonline.Productos.presentation.view.Listener
import com.example.proyectsoreonline.R
import com.example.proyectsoreonline.Productos.data.model.Productoss
import com.example.proyectsoreonline.Productos.presentation.presenter.ProductosPresenter
import com.example.proyectsoreonline.Productos.presentation.view.ProductosView
import com.example.proyectsoreonline.utils.LoadingDialog
import kotlinx.android.synthetic.main.fragment_ejemplo_consumo.*
import net.grandcentrix.thirtyinch.TiFragment
import java.lang.Exception
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 */
class ProductosFragment : TiFragment<ProductosPresenter, ProductosView>(), ProductosView,Listener, MyAdapter.ItemClickListener {

    private var indeterminateDialog: LoadingDialog? = null

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
            //pintarElementosLista(ArrayList<com.example.proyectsoreonline.Productos.data.model.Productoss>())




            showProgress()
           presenter.ListaDeArticulos("1")


//            presenter.ListaDeArticulos("Soccer")

    }

     fun pintarElementosLista(lista: ArrayList<Productoss>) {


       // var lista = ArrayList<com.example.proyectsoreonline.Productos.data.model.Productoss>()

     //   lista.add(com.example.proyectsoreonline.Productos.data.model.Productoss())
         adaptadorLista = MyAdapter(context!!, lista)
         adaptadorLista!!.setClickListener(this)
               var miManager = LinearLayoutManager(context)
               //miManager = GridLayoutManager(this,2)
               miRecycler.layoutManager = miManager
               miRecycler.adapter =adaptadorLista

               //values.add("tipoDeporte: ${it.getTipo()} \n nombre: ${it.getNom()} \n img: ${it.getImg()} \n descripcion: ${it.getDescripcion() } \n stock: ${it.getStock()} \n  precio: ${it.getPrecio() }  \n descuento: ${it.getDescuento()}")
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
}



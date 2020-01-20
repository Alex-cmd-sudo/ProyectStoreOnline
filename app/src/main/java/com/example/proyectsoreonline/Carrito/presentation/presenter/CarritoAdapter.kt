package com.example.proyectsoreonline.Carrito.presentation.presenter

import android.content.Context
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectsoreonline.Carrito.fragment.CarritoFragment
import com.example.proyectsoreonline.Productos.Productos
import com.example.proyectsoreonline.Productos.data.model.Productoss
import com.example.proyectsoreonline.Productos.fragment.ProductosFragment
import com.example.proyectsoreonline.Productos.presentation.presenter.MyAdapter
import com.example.proyectsoreonline.R
import kotlinx.android.synthetic.main.item_list_carrito.*

class CarritoAdapter// data is passed into the constructor
    internal constructor(context: Context, private val mData: ArrayList<ProductosFragment>) :
        RecyclerView.Adapter<CarritoAdapter.ViewHolder>() {


        private var mContext: Context

        private val mInflater: LayoutInflater
        private var mClickListener: ItemClickListener? = null

        init {
            this.mInflater = LayoutInflater.from(context)
            mContext = context
        }

        // inflates the row layout from xml when needed
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = mInflater.inflate(R.layout.item_list_carrito, parent, false)

            return ViewHolder(view)
        }

        // binds the data to the TextView in each row
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            //var listaElementosDeCarrito = mData[position]
            val listaProductos = mData[position]
            //var listaDeCarritoFragment = mData[position]

            holder.producto.text = listaProductos.toString()
            holder.precio.text = listaProductos.toString()
            holder.stock.text = listaProductos.toString()
            holder.imagenProducto =listaProductos.img


//            val imageByteArray = Base64.decode(listaProductos.img, Base64.DEFAULT)
//            Glide.with(mContext)
//                .asBitmap()
//                .load(imageByteArray)
//                .into(  holder.imagenProducto )
        }

        // total number of rows
        override fun getItemCount(): Int {
            return mData.size
        }

        // stores and recycles views as they are scrolled off screen
        inner class ViewHolder internal constructor(itemView: View) :
            RecyclerView.ViewHolder(itemView),
            View.OnClickListener {
            internal var imagenProducto: ImageView
            internal var producto: TextView
            internal var precio: TextView
            internal var stock: TextView

            init {

                imagenProducto = itemView.findViewById(R.id.img)
                producto = itemView.findViewById(R.id.txt_producto)
                precio = itemView.findViewById(R.id.txt_precio)
                stock = itemView.findViewById(R.id.txt_stock)

                itemView.setOnClickListener(this)

            }

            override fun onClick(v: View?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }

        // convenience method for getting data at click position
        internal fun getItem(id: Int): ProductosFragment {
            return mData[id]
        }

        // allows clicks events to be caught
        internal fun setClickListenerCarrito(itemClickListener: ItemClickListener) {
            this.mClickListener = itemClickListener
        }

        // parent activity will implement this method to respond to click events
        interface ItemClickListener {
            fun onItemClick(view: View, position: Int)
            fun addToCart(position: Int)
        }


    }

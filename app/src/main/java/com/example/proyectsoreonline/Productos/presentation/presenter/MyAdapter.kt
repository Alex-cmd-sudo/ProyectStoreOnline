package com.example.proyectsoreonline.Productos.presentation.presenter

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
import com.example.proyectsoreonline.Productos.data.model.Productoss
import com.example.proyectsoreonline.R


class MyAdapter// data is passed into the constructor
internal constructor(context: Context, private val mData: ArrayList<Productoss>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    private var mContext:Context

    private val mInflater: LayoutInflater
    private var mClickListener: ItemClickListener? = null

    init {
        this.mInflater = LayoutInflater.from(context)
        mContext =context
    }

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       var productoEnLista= mData[position]
//        holder.myTextView  text = animal
        holder.precio.text = productoEnLista.precio.toString()
        holder.producto.text = productoEnLista.nombreProducto
        holder.stock.text = productoEnLista.stock.toString()

        val imageByteArray = Base64.decode(productoEnLista.img, Base64.DEFAULT)
        Glide.with(mContext)
            .asBitmap()
            .load(imageByteArray)
            .into(  holder.imagenProducto )

        if(holder.stock.text.toString() == "0"){
            holder.btnAddCarrito.isEnabled = false
            holder.btnAddCarrito.text = "No disponible"
        }else{
            holder.btnAddCarrito.isEnabled = true
            holder.btnAddCarrito.text = "AGREGAR"
        }

    }

    // total number of rows
    override fun getItemCount(): Int {
        return mData.size
    }
    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        internal var btnAddCarrito: Button
        internal var imagenProducto: ImageView
        internal var producto: TextView
        internal var precio: TextView
        internal var stock: TextView

        init {
            btnAddCarrito = itemView.findViewById(R.id.btn_carrito)
            imagenProducto = itemView.findViewById(R.id.img)
            producto = itemView.findViewById(R.id.txt_producto)
            precio = itemView.findViewById(R.id.txt_precio)
            stock = itemView.findViewById(R.id.txt_stock)

            itemView.setOnClickListener(this)


            btnAddCarrito.setOnClickListener {
                if (mClickListener != null) mClickListener!!.addToCart(adapterPosition)
            }
        }

        override fun onClick(view: View) {
            if (mClickListener != null) mClickListener!!.onItemClick(view, adapterPosition)
        }
    }

    // convenience method for getting data at click position
    internal fun getItem(id: Int): Productoss {
        return mData[id]
    }

    // allows clicks events to be caught
    internal fun setClickListener(itemClickListener: ItemClickListener) {
        this.mClickListener = itemClickListener
    }

    // parent activity will implement this method to respond to click events
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
        fun addToCart(position: Int)
    }
}

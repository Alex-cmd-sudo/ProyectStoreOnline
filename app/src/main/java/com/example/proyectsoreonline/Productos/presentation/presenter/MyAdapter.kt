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

        holder.precio.text = productoEnLista.precio.toString()
        holder.producto.text = productoEnLista.nombreProducto
        holder.stock.text = productoEnLista.stock.toString()


        val imageByteArray = Base64.decode(productoEnLista.img, Base64.DEFAULT)
        Glide.with(mContext)
            .asBitmap()
            .load(imageByteArray)
            .into(  holder.imagenProducto )

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




//class MyAdapter(var lista:ArrayList<Productoss>, var vista: Listener): RecyclerView.Adapter<MyAdapter.miViewHolder>(){
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.miViewHolder {
//        var vistaXml = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
//        return miViewHolder(vistaXml,vista)
//    }
//
//    override fun getItemCount(): Int {
//        return lista.size
//    }
//
//    override fun onBindViewHolder(holder: MyAdapter.miViewHolder, position: Int) {
//        var item = lista.get(position)
//        holder.enlazar(item,vista)
//    }
//
//    class miViewHolder(itemView: View, view:Listener):RecyclerView.ViewHolder(itemView){
//
//
//        fun enlazar(
//            productos: Productoss,
//            vista: Listener
//        ){
//
////            itemView.producto.text = productos.getNom()
////            itemView.stock.text = productos.getStock().toString()
////            itemView.precio.text = productos.getPrecio().toString()
//
////            var foto:String = ""
////            foto=productos.getImg()!!
////
////            val imageBytes = Base64.decode(foto, Base64.DEFAULT)
////            val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
////            val byteArrayOutputStream = ByteArrayOutputStream()
////
////            decodedImage.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
////            val byteArray = byteArrayOutputStream.toByteArray()
////            var encoded = Base64.encodeToString(byteArray, Base64.DEFAULT)
////            var myUri = Uri.parse(encoded)
//
//
//            //itemView.img.setImageURI(myUri)
//
//            }
//        }
//
//    }

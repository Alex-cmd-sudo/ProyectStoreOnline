package com.example.proyectsoreonline.Productos.data.model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class Productoss: RealmObject() {

    @SerializedName("tipoDeporte")
    @Expose
    var tipoDeporte: String? = null
    @SerializedName("nombreProducto")
    @Expose
    var nombreProducto: String? = null
    @SerializedName("img")
    @Expose
    var img: String? = null
    @SerializedName("descripcion")
    @Expose
    var descripcion: String? = null
    @SerializedName("stock")
    @Expose
    var stock: Int? = null
    @SerializedName("precio")
    @Expose
    var precio: Double? = null
    @SerializedName("descuento")
    @Expose
    var descuento: Int? = null

    fun withTipoDeporte(tipoDeporte: String): Productoss {
        this.tipoDeporte = tipoDeporte
        return this
    }

    fun withNombreProducto(nombreProducto: String): Productoss {
        this.nombreProducto = nombreProducto
        return this
    }

    fun withImg(img: String): Productoss {
        this.img = img
        return this
    }

    fun withDescripcion(descripcion: String): Productoss {
        this.descripcion = descripcion
        return this
    }

    fun withStock(stock: Int?): Productoss {
        this.stock = stock
        return this
    }

    fun withPrecio(precio: Double?): Productoss {
        this.precio = precio
        return this
    }

    fun withDescuento(descuento: Int?): Productoss {
        this.descuento = descuento
        return this
    }

}
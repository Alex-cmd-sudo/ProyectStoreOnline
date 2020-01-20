package com.example.proyectsoreonline.Productos.data.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class ListaProductos: RealmObject() {
    var productos : RealmList<Productoss> = RealmList()
}
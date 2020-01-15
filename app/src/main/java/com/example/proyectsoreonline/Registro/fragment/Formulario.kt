package com.example.proyectsoreonline.Registro.fragment


import android.annotation.SuppressLint
import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.proyectsoreonline.utils.ImageUtil
import com.example.proyectsoreonline.R
import com.example.proyectsoreonline.Registro.presentacion.presenter.RegistroPresenter
import com.example.proyectsoreonline.Registro.presentacion.view.RegistroView
import com.tbruyelle.rxpermissions.RxPermissions
import kotlinx.android.synthetic.main.fragment_formulario.*
import net.grandcentrix.thirtyinch.TiFragment
import java.security.MessageDigest


/**
 * A simple [Fragment] subclass.
 */
class Formulario: TiFragment<RegistroPresenter, RegistroView>(), RegistroView{

    var ide:String=""
    var contrasena:String=""
    private val Image_Capture_Code_Anverso = 1
    private val Image_Capture_Code_Reverso = 2

    var anverso :String=""
    var reverso :String=""

    var a:Boolean=false
    var r:Boolean=false



    var connected = false


    var mCallback : FormularioCallBacks?=  null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mCallback = activity as FormularioCallBacks
        }
        catch (e:Exception){}

    }

    @SuppressLint("MissingSuperCall")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_formulario, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var rxPermissions = RxPermissions(activity!!)

        val cm = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo

        btn_volver.setOnClickListener {
            mCallback!!.callFragmentLogin()}

        btn_guardar.setOnClickListener {


            var nombre = et_name.text.toString()
            val  apaterno = et_paterno.text.toString()
            val  correo = et_correo.text.toString()
            var  contrasena = et_contrasena.text.toString()
            var  confirmar = et_confirmacion.text.toString()


            if (nombre.isNotEmpty()) {//Nombre

                //if (nombre.length<=4){//Nombre muy corto

                    if (apaterno.isNotEmpty()) {//Apellido

                        //if (ap.length>4) {

                            if (correo.isNotEmpty()) {//Correo

                                //if(correo.length<10) {

                                    if (isEmailValid(et_correo.text.toString())
                                    ) {

                                    if (contrasena.isNotEmpty()) {//Contraseña

                                        if (contrasena.length>=8) {//Confirmar

                                            if (confirmar.length >= 8) {

                                                if (contrasena == confirmar) {

                                                    if(a==true&&r==true) {

                                                        if (identificacion.isChecked) {


                                                            if (networkInfo != null && networkInfo.isConnected) {

                                                                var ide: String = "ife"

                                                                presenter.registroUsuario(
                                                                    et_name.text.toString(),
                                                                    et_paterno.text.toString(),
                                                                    et_materno.text.toString(),
                                                                    et_correo.text.toString(),
                                                                    contrasena.sha256(),
                                                                    anverso,
                                                                    reverso,
                                                                    ide)
                                                            }//a<fasfz

                                                            else {
                                                                Toast.makeText(
                                                                    context,
                                                                    "No hay ninguna conexion de red",
                                                                    Toast.LENGTH_LONG
                                                                ).show()
                                                            }

                                                        } else {

                                                            if (networkInfo != null && networkInfo.isConnected) {

                                                            var ide: String = "ine"

                                                            presenter.registroUsuario(
                                                                et_name.text.toString(),
                                                                et_paterno.text.toString(),
                                                                et_materno.text.toString(),
                                                                et_correo.text.toString(),
                                                                contrasena.sha256(),
                                                                anverso,
                                                                reverso,
                                                                ide)
                                                            }
                                                            else{
                                                            Toast.makeText(
                                                                context,
                                                                "No hay ninguna conexion de red",
                                                                Toast.LENGTH_LONG
                                                            ).show()}
                                                        }

                                                    }

                                                    else{
                                                        Toast.makeText(context,"Captura ambas caras de tu credencial",Toast.LENGTH_LONG).show()
                                                    }

                                                } else {Toast.makeText(context,"Las contraseñas no son iguales",Toast.LENGTH_LONG).show()}//Contraseña muy pequeña

                                            } else {Toast.makeText(context,"Confirma tu contraseña",Toast.LENGTH_LONG).show()}//Desiguales


                                        } else {Toast.makeText(context,"Contraseña debe ser mayor a 8 caracteres",Toast.LENGTH_LONG).show()}//Contraseña corroborada

                                    } else {Toast.makeText(context,"Introduce una contraseña",Toast.LENGTH_LONG).show()}//Contraseña

                                   } else {Toast.makeText(context,"El correo es invalido",Toast.LENGTH_LONG).show()}//No existe el dominio

                                //}else {Toast.makeText(context, "Correo muy corto", Toast.LENGTH_LONG).show()}//Correo corto

                            } else {Toast.makeText(context, "Complete el campo correo", Toast.LENGTH_LONG).show()}//Correo

                        //}else{Toast.makeText(context, "Apellido corto", Toast.LENGTH_LONG).show()}//Apellido corto

                 } else {Toast.makeText(context,"Complete el campo apellido paternno",Toast.LENGTH_LONG).show()}//Paterno


            //} else {Toast.makeText(context, "Nombre corto", Toast.LENGTH_LONG).show()}//Nombre corto


            }else{Toast.makeText(context, "Complete el campo nombre", Toast.LENGTH_LONG).show()}//Nombre


        }


        btn_anverso.setOnClickListener {

            val cInt = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cInt, Image_Capture_Code_Anverso)

        }//Camara Anverso

        btn_reverso.setOnClickListener {

            val cInt = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cInt, Image_Capture_Code_Reverso)

        }//Camara Reverso


    }//AQUI TERMINA EL FRAGMENT

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode === Image_Capture_Code_Anverso)
        {
            if (resultCode === RESULT_OK)
            {
                val bp = data!!.getExtras()!!.get("data") as Bitmap
                img_anverso.setImageBitmap(bp)
                anverso = ImageUtil.convert(bp)
                a=true
            }
            else if (resultCode === RESULT_CANCELED)
            {
                Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
            }
        }

        if (requestCode === Image_Capture_Code_Reverso)
        {
            if (resultCode === RESULT_OK)
            {
                val bp = data!!.getExtras()!!.get("data") as Bitmap
                img_reverso.setImageBitmap(bp)
                reverso = ImageUtil.convert(bp)
                r=true
            }
            else if (resultCode === RESULT_CANCELED)
            {
                Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
            }
        }

    }

    fun String.md5(): String {
        return hashString(this, "MD5")
    }

    fun String.sha256(): String {
        return hashString(this, "SHA-256")
    }

    private fun hashString(input: String, algorithm: String): String {
        return MessageDigest
            .getInstance(algorithm)
            .digest(input.toByteArray())
            .fold("", { str, it -> str + "%02x".format(it) })
    }

    companion object {
        val TAG = Formulario::class.java.simpleName
    }

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun providePresenter(): RegistroPresenter {
        return RegistroPresenter()
    }

    override fun mostrarResultadoDeRegistro(descripcion: String) {

        val result:String="Felicidades el registro es exitoso"
        if(descripcion.equals(result)){

            Toast.makeText(context, "$descripcion", Toast.LENGTH_LONG).show()
            mCallback!!.callFragmentLogin()
        }

        else{
            Toast.makeText(context, "$descripcion", Toast.LENGTH_LONG).show()
        }
    }

    override fun mostrarResultadoRegistro(codigo: String) {

    }

    interface FormularioCallBacks {
        fun callFragmentLogin() {
        }
    }




}
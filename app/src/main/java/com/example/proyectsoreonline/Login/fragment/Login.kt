package com.example.proyectsoreonline.Registro.fragment


import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.proyectsoreonline.Productos.data.model.GetProductosRequest
import com.example.proyectsoreonline.R
import com.example.proyectsoreonline.Registro.presentacion.presenter.LoginPresenter
import com.example.proyectsoreonline.Registro.presentacion.view.LoginView
import com.tbruyelle.rxpermissions.RxPermissions
import kotlinx.android.synthetic.main.fragment_formulario.*
import kotlinx.android.synthetic.main.fragment_login.*
import net.grandcentrix.thirtyinch.TiFragment
import java.security.MessageDigest


/**
 * A simple [Fragment] subclass.
 */
class Login : TiFragment<LoginPresenter, LoginView>(), LoginView {

    var mCallback : LoginCallBacks?=  null
    var code:Boolean=false
    var mensaje:String=""


    override fun providePresenter(): LoginPresenter {
        return LoginPresenter()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun mostrarResultadoDeLogin(descripcion: String) {

        val result:String="¡Ha iniciado Sesión!"
        val incorrect:String="!Usuario no registrado!"

        if(descripcion.equals(result)){
            Toast.makeText(context, "$descripcion", Toast.LENGTH_LONG).show()
            mCallback!!.callFragmentProductos()
        }

        else{
            Toast.makeText(context, "$descripcion", Toast.LENGTH_LONG).show()
        }


    }

    override fun mostrarCodigoLogin(codigo: String) {

    }


    @SuppressLint("MissingSuperCall")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var rxPermissions = RxPermissions(activity!!)

        val cm = context!!.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo



        btn_iniciar.setOnClickListener {

            var usuario = user.text.toString()
            var pass = password.text.toString()

           if (usuario.isNotEmpty()) {


               if (isEmailValid(user.text.toString())){

                   if (pass.isNotEmpty()) {

                       if(pass.length>7) {

                           if(networkInfo != null && networkInfo.isConnected){

                               presenter.registroUsuario(
                                   user.text.toString(),
                                   pass.sha256())

                               //mCallback!!.callFragmentProductos()
                           }

                           else{Toast.makeText(context, "No hay conexion a internet", Toast.LENGTH_LONG).show()}

                       }else{Toast.makeText(context, "La contraseña debe ser mayor a 8 caracteres", Toast.LENGTH_LONG).show()}

                   }else {Toast.makeText(context, "Contraseña vacia", Toast.LENGTH_LONG).show()//Usuario
               password.requestFocus()}

           }else{Toast.makeText(context, "Correo invalido", Toast.LENGTH_LONG).show()//Contraseña
                 user.requestFocus()}
            } else {Toast.makeText(context, "Usuario vacio", Toast.LENGTH_LONG).show()//Contraseña
                user.requestFocus()}

        }//Campos vacios negados


        tv_registrar.setOnClickListener{
            mCallback!!.callFragmentRegistro()
        }

        fun cambiarActvidad() {
            var user = et_correo.text.toString()

            var obj = Bundle()
            obj.putSerializable("correo",user)

            val intento = Intent(context,GetProductosRequest::class.java)
            intento.putExtras(obj)
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

    companion object{
        val TAG = Login::class.java.simpleName
        fun newInstance() = Login()
    }

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

 override fun onAttach(context: Context) {
     super.onAttach(context)
     try {
         mCallback = activity as LoginCallBacks
     }
     catch (e:Exception){
     }
 }

    interface LoginCallBacks : Formulario.FormularioCallBacks {
        fun callFragmentRegistro() {
        }


        fun callFragmentProductos(){

        }
    }

}

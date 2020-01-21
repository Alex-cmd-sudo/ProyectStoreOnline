package com.example.proyectsoreonline.Tarjeta.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.proyectsoreonline.R
import kotlinx.android.synthetic.main.fragment_tarjeta.*

/**
 * A simple [Fragment] subclass.
 */
class Tarjeta : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tarjeta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_pagar.setOnClickListener {
            if(et_cvv.length()>2){

                 var cad :String=""
                cad==et_cvv.toString()+"/"
                Log.d("fecha",cad)

            }
        }




    }


}

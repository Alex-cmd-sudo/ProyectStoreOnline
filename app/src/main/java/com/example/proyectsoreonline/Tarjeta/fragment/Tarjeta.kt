package com.example.proyectsoreonline.Tarjeta.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.proyectsoreonline.R

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


}

package com.digitalhouse.dsafiowebservices.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.digitalhouse.dsafiowebservices.R
import kotlinx.android.synthetic.main.cadastro_body.view.*
import kotlinx.android.synthetic.main.fragment_cadastro.view.*



class FragmentCadastro : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cadastro, container, false)

        registrado(view)
        backLogin(view)

        return view
    }

    private fun registrado(view: View) {
        view.btn_register.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentCadastro_to_fragmentList)
        }
    }

    private fun backLogin(view: View){
        view.ivBack.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentCadastro_to_fragmentLoginBack)

        }
    }

}
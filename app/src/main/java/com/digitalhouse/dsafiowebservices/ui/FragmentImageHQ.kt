package com.digitalhouse.dsafiowebservices.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import br.com.digitalhouse.dsafiowebservices.comics.Result
import com.digitalhouse.dsafiowebservices.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_image_h_q.*
import kotlinx.android.synthetic.main.fragment_image_h_q.view.*
import kotlinx.android.synthetic.main.fragment_list_h_q.view.*
import kotlinx.android.synthetic.main.item_hqs.*
import kotlinx.android.synthetic.main.item_hqs.view.*

class FragmentImageHQ : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image_h_q, container, false)
        val picasso = Picasso.get()
        val showHQ = imgScreen(picasso, view)

        backDetailsHQ(showHQ, view)

        return view
    }

    private fun imgScreen(
        picasso: Picasso,
        view: View
    ): br.com.digitalhouse.dsafiowebservices.comics.Result {
        val hq = arguments?.get("chave") as br.com.digitalhouse.dsafiowebservices.comics.Result

        picasso.load(hq.thumbnail.path.replace(
            "http://", "https://") +"."+ hq.thumbnail.extension)
            .into(view.iv_fragImage)
        return hq
    }


    private fun backDetailsHQ(hqImg: Result, view: View) {

        val bundle = bundleOf("chave" to hqImg)
        view.toolbar_fragImageHQ.setNavigationOnClickListener {
            findNavController().navigate(
                R.id.action_fragmentImageHQ_to_fragmentDetail, bundle)
        }
    }
}
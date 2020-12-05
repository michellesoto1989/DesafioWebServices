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
import kotlinx.android.synthetic.main.fragment_detail.view.*

 class FragmentDetail : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val picasso = Picasso.get()
        getImage(picasso, view)
        val comicDetail = getObjHQ()

        ComicsDetail(comicDetail, view, picasso)
        openImg(comicDetail, view)
        backListHQ(view)

        return view
    }


    private fun backListHQ(view: View) {
        view.toolbar_fragDetail.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_fragmentDetail_to_fragmentListHQ)
        }
    }

    private fun openImg(hqDetail: br.com.digitalhouse.dsafiowebservices.comics.Result, view: View) {
        val bundle = bundleOf("chave" to hqDetail)
        view.iv_capa_fragmentDetails.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragmentDetail_to_fragmentImageHQ, bundle
            )
        }
    }

    private fun ComicsDetail(


        comicDetail: br.com.digitalhouse.dsafiowebservices.comics.Result,
        view: View,
        picasso: Picasso
    ) {
        view.tv_titulo_fragDetail.text = comicDetail.title
        view.tv_descricao_fragDetail.text = comicDetail.description
        view.tv_price_fragDetail.text = comicDetail.prices[0].price
        view.tv_pages_fragDetail.text = comicDetail.pageCount.toString()
        view.tv_published_fragDetail.text = comicDetail.dates[0].date



        picasso.load(comicDetail.thumbnail.path.replace("http://", "https://")
                +"."+ comicDetail.thumbnail.extension).into(view.iv_capa_fragmentDetails)
    }

    private fun getObjHQ(): br.com.digitalhouse.dsafiowebservices.comics.Result {
        return arguments?.get("chave") as Result
    }

    private fun getImage(picasso: Picasso, view: View) {
        picasso.load(
            "https://i.annihil.us/u/prod/marvel/i/mg/3/50/526548a343e4b"
                    + "/landscape_large."
                    + "jpg"
        ).into(view.iv_fragDetail)
    }
}
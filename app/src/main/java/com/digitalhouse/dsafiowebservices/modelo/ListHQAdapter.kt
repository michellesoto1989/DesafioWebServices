package com.digitalhouse.dsafiowebservices.modelo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.dsafiowebservices.comics.Result
import br.com.digitalhouse.dsafiowebservices.modelo.FragmentListHQ
import com.digitalhouse.dsafiowebservices.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hqs.view.*

class ListHQAdapter(val listHQ: List<Result>, val listener: FragmentListHQ) :
    RecyclerView.Adapter<ListHQAdapter.viewHolderHQ>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderHQ {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hqs, parent, false)
        return viewHolderHQ(view)
    }

    override fun onBindViewHolder(holder: viewHolderHQ, position: Int) {
        val hq = listHQ[position]

        holder.numHQ.text = hq.title
        Picasso.get().load(hq.thumbnail.path.replace("http://", "https://")
                +"."+ hq.thumbnail.extension)
            .into(holder.imgCapa)

        holder.itemView.setOnClickListener {
            listener.hqClick(position)
        }
    }

    interface onClickHQ{
        fun hqClick(position: Int)
    }


    override fun getItemCount(): Int = listHQ.size

    inner class viewHolderHQ(view: View) : RecyclerView.ViewHolder(view) {
        val imgCapa: ImageView = view.iv_imgListHQ
        val numHQ: TextView = view.tv_itemHQ


    }
}
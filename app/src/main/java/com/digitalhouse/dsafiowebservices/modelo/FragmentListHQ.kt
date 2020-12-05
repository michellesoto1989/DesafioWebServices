package br.com.digitalhouse.dsafiowebservices.modelo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.dsafiowebservices.repository.service
import com.digitalhouse.dsafiowebservices.R
import com.digitalhouse.dsafiowebservices.modelo.ListHQAdapter
import com.digitalhouse.dsafiowebservices.modelo.ListHQViewModel
import kotlinx.android.synthetic.main.fragment_list_h_q.view.*

class FragmentListHQ : Fragment(), ListHQAdapter.onClickHQ{

    var offset = 1
    private lateinit var adapterHQ: ListHQAdapter
    private lateinit var layoutManagerHQ: GridLayoutManager

    private val viewModel by viewModels<ListHQViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ListHQViewModel(service) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_h_q, container, false)

        GridLayoutManager(context, 3).also { layoutManagerHQ = it }
        view.rv_fragment_list_HQ.layoutManager = layoutManagerHQ


        viewModel.listComics.observe(viewLifecycleOwner, {
            adapterHQ = ListHQAdapter(it, this)
            view.rv_fragment_list_HQ.adapter = adapterHQ
        })

        viewModel.getListHQs(offset)
        setScrollView(view)

        return view
    }
      override fun hqClick(position: Int) {
        viewModel.listComics.observe(this, {
            val selectHQ = it[position]

            val bundle = bundleOf("chave" to selectHQ)
            findNavController().navigate(R.id.action_fragmentListHQ_to_fragmentDetail, bundle)
        })
    }

    private fun setScrollView(view: View) {
        view.rv_fragment_list_HQ?.run {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    val itensTotal = adapterHQ.itemCount
                    val itensVisible = layoutManagerHQ.childCount
                    val itensPass = layoutManagerHQ.findFirstVisibleItemPosition()

                    if ((itensVisible + itensPass) == itensTotal) {
                        offset++
                        viewModel.getListHQs(offset)
                    }
                }
            })
        }
    }
}
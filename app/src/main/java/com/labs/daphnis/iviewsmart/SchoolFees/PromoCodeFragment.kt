package com.labs.daphnis.iviewsmart.SchoolFees

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.labs.daphnis.iviewsmart.R
import kotlinx.android.synthetic.main.fragment_promo_code.view.*



class PromoCodeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_promo_code, container, false)

        view.promo_recycler?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        view.promo_recycler?.adapter = PromoCodeAdapter(context)

        view.promo_recycler?.addItemDecoration(DividerItemDecoration(context,LinearLayoutManager.VERTICAL))

        return view
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            PromoCodeFragment().apply {
                arguments = Bundle().apply {
                    //
                }
            }
    }
}

package com.labs.daphnis.schoolapp.ViewStatement


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.labs.daphnis.schoolapp.R
import kotlinx.android.synthetic.main.fragment_statement.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"


class StatementFragment : Fragment() {

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_statement, container, false)



        view.statement_recycler_view?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        view.statement_recycler_view?.adapter = StatementViewAdapter(context)



        return view
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            StatementFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)

                }
            }
    }
}

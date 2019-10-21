package com.labs.daphnis.iviewsmart


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import com.labs.daphnis.iviewsmart.SchoolFees.SchoolFeesActivity
import com.labs.daphnis.iviewsmart.ViewStatement.ViewStatementActivity
import com.labs.daphnis.schoolapp.R
import kotlinx.android.synthetic.main.fragment_dashboard.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DashboardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_dashboard, container, false)

        grid_btn?.getChildAt(0)?.setOnClickListener{
            startActivity(Intent(activity, SchoolFeesActivity::class.java))
        }
//        school_btn?.setOnClickListener {
//
//            startActivity(Intent(activity,SchoolFeesActivity::class.java))
//        }

        val btn : LinearLayout = view.findViewById(R.id.school_btn)
        val add_money_btn : Button = view.findViewById(R.id.btn_add_money)
        val btn_view_stmnt : Button = view.findViewById(R.id.btn_view_stmnt)

        add_money_btn.setOnClickListener {
            startActivity(Intent(activity,AddMoneyActivity::class.java))
        }

        btn.setOnClickListener {
            startActivity(Intent(activity, SchoolFeesActivity::class.java))
        }

        btn_view_stmnt.setOnClickListener {
            startActivity(Intent(activity, ViewStatementActivity::class.java))
        }

        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DashboardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashboardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
        @JvmStatic
        fun newInstance(){
            DashboardFragment().apply {  }
        }
    }
}

package com.labs.daphnis.schoolapp.SchoolFees


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.LocaleList
import android.support.design.widget.TextInputLayout
import android.support.v4.app.Fragment
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.labs.daphnis.schoolapp.R
import com.labs.daphnis.schoolapp.SchoolFees.SchoolLocationDir.LocationList


/**
 * A simple [Fragment] subclass.
 * Use the [SchoolLocationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SchoolLocationFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_school_location, container, false)

        val emailTv = view.findViewById<TextView>(R.id.email_tv)
        val proceedBtn = view.findViewById<Button>(R.id.proceed)
        val editLocation = view.findViewById<EditText>(R.id.edit_location)
        val editSchool = view.findViewById<EditText>(R.id.edit_school)


        val ss = SpannableString(resources.getString(R.string.school_frg_text_email))
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                //                startActivity(new Intent(getActivity(), NextActivity.class));
                Toast.makeText(activity,"Clicked",Toast.LENGTH_SHORT).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
            }
        }

        ss.setSpan(clickableSpan, 79, 98, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


        emailTv.text = ss
        emailTv.movementMethod = LinkMovementMethod.getInstance()
        emailTv.highlightColor = Color.TRANSPARENT

        proceedBtn?.setOnClickListener {
            startActivity(Intent(activity, DetailActivity::class.java))
        }

        editLocation.setOnClickListener {
            startActivity(Intent(context, LocationList::class.java))
        }

        return view
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SchoolLocationFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): SchoolLocationFragment {
            val fragment = SchoolLocationFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor

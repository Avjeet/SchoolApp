package com.labs.daphnis.iviewsmart.Activity.PhotoGallery


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.labs.daphnis.iviewsmart.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ImageID = "imageid"

class PhotoFullScreen : Fragment() {
    // TODO: Rename and change types of parameters
    private var ImageId: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            ImageId = it.getInt(ImageID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_photo_full_screen, container, false)


        return view
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: Int) =
            PhotoFullScreen().apply {
                arguments = Bundle().apply {
                    putInt(ImageID, param1)
                }
            }
    }
}

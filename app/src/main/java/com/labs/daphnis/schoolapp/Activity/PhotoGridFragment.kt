package com.labs.daphnis.schoolapp.Activity


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.labs.daphnis.schoolapp.R

import kotlinx.android.synthetic.main.fragment_photo_grid.view.*

class PhotoGridFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_photo_grid, container, false)

        view.photo_recycler_view?.layoutManager = GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false)

        view.photo_recycler_view?.adapter = PhotoAdapter(context)

        return view
    }


}

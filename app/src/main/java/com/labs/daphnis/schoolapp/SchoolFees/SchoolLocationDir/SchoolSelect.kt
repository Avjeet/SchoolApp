package com.labs.daphnis.schoolapp.SchoolFees.SchoolLocationDir

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.labs.daphnis.schoolapp.R
import kotlinx.android.synthetic.main.activity_school_select.*

class SchoolSelect : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_select)

        school_select_recycler.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)

        school_select_recycler.adapter = SchoolSelectAdapter(this)
    }
}

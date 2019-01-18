package com.labs.daphnis.schoolapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_school_fees.*

class SchoolFeesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_fees)

        setSupportActionBar(toolbar)
        toolbar.title = "School Fees"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = SchoolLocationFragment()

        fragmentTransaction.add(R.id.content_fragment, fragment).commit()
    }
}

package com.labs.daphnis.schoolapp.SchoolFees

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.labs.daphnis.schoolapp.R

class SchoolFeesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_fees)



        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.school_fees)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = SchoolLocationFragment()

        fragmentTransaction.add(R.id.content_fragment, fragment).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}

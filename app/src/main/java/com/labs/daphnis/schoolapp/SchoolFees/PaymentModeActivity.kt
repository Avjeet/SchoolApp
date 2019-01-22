package com.labs.daphnis.schoolapp.SchoolFees

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.labs.daphnis.schoolapp.R

class PaymentModeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_mode)

        supportActionBar?.title= getString(R.string.school_fees)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

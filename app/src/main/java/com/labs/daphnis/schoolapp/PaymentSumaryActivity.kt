package com.labs.daphnis.schoolapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class PaymentSumaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_sumary)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.school_fees)
    }
}

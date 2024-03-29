package com.labs.daphnis.iviewsmart.SchoolFees

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.labs.daphnis.iviewsmart.R
import kotlinx.android.synthetic.main.activity_payment_sumary.*

class PaymentSumaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_sumary)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.school_fees)

        proceed.setOnClickListener {
            startActivity(Intent(this@PaymentSumaryActivity, PaymentModeActivity::class.java))
        }

        promocode_link.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()

            val fragment = PromoCodeFragment.newInstance()

            transaction.add(R.id.promo_fragment_container,fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }


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

    override fun onBackPressed() {
        super.onBackPressed()
    }
}

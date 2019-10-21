package com.labs.daphnis.iviewsmart.SchoolFees

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.labs.daphnis.iviewsmart.HomeActivity
import com.labs.daphnis.iviewsmart.R
import kotlinx.android.synthetic.main.activity_payment_complete.*

class PaymentCompleteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_complete)

        supportActionBar?.title= getString(R.string.school_fees)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        proceed_to_home.setOnClickListener {
            intent = Intent(this,HomeActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            overridePendingTransition(R.anim.abc_popup_enter,R.anim.abc_popup_exit)
            finish()
        }

    }

    override fun onBackPressed() {
        intent = Intent(this,HomeActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        overridePendingTransition(R.anim.abc_popup_enter,R.anim.abc_popup_exit)
        finish()
    }
}

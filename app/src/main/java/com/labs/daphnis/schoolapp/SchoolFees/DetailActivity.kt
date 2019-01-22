package com.labs.daphnis.schoolapp.SchoolFees

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.labs.daphnis.schoolapp.R
import kotlinx.android.synthetic.main.activity_detail.*

/**
 * Created by Your name on 18-01-2019.
 */
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.school_fees)

        edit_location.setText( "Delhi,India")

        edit_school.setText("JK School")

        edit_enroll.setText("EJADSKB838YE389")

        edit_name.setText("Avjeet SIngh")

        proceed.setOnClickListener {
            startActivity(Intent(this@DetailActivity, PaymentSumaryActivity::class.java))
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
}
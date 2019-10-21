package com.labs.daphnis.iviewsmart.SchoolFees

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.labs.daphnis.iviewsmart.R
import com.labs.daphnis.iviewsmart.SchoolFees.SchoolLocationDir.LocationSelect
import com.labs.daphnis.iviewsmart.SchoolFees.SchoolLocationDir.SchoolSelect
import kotlinx.android.synthetic.main.activity_school_fees.*

class SchoolFeesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_fees)



        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.school_fees)

        val ss = SpannableString(resources.getString(R.string.school_frg_text_email))
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                //                startActivity(new Intent(getActivity(), NextActivity.class));
                Toast.makeText(this@SchoolFeesActivity, "Clicked", Toast.LENGTH_SHORT).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
            }
        }

        ss.setSpan(clickableSpan, 79, 98, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


        email_tv.text = ss
        email_tv.movementMethod = LinkMovementMethod.getInstance()
        email_tv.highlightColor = Color.TRANSPARENT

       proceed?.setOnClickListener {
            startActivity(Intent(this@SchoolFeesActivity, DetailActivity::class.java))
        }

        edit_location.setOnClickListener {
            startActivityForResult(Intent(this@SchoolFeesActivity, LocationSelect::class.java),1)
        }

        edit_school.setOnClickListener {
            startActivityForResult(Intent(this@SchoolFeesActivity, SchoolSelect::class.java),2)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode){
            1 -> {
                if (resultCode == Activity.RESULT_OK) {
                    edit_location.setText(data?.data.toString())
                }
            }

            2 ->{
                if (resultCode == Activity.RESULT_OK) {
                    edit_school.setText(data?.data.toString())
                }
            }
        }
    }
}

package com.labs.daphnis.schoolapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.warkiz.widget.IndicatorSeekBar
import com.warkiz.widget.OnSeekChangeListener
import com.warkiz.widget.SeekParams
import kotlinx.android.synthetic.main.activity_add_money.*

class AddMoneyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_money)

        seek_bar.onSeekChangeListener = object : OnSeekChangeListener {
            override fun onStartTrackingTouch(seekBar: IndicatorSeekBar?) {
               // dp nothing
            }

            override fun onStopTrackingTouch(seekBar: IndicatorSeekBar?) {
                // do nothing
            }

            override fun onSeeking(seekParams: SeekParams?) {
                fund_value.text = "$ ${seek_bar.progress}"
            }
        }
    }
}

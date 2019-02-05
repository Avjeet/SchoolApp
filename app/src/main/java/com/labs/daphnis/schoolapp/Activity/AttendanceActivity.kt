package com.labs.daphnis.schoolapp.Activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.labs.daphnis.schoolapp.R
import kotlinx.android.synthetic.main.activity_attedance.*
import devlight.io.library.ArcProgressStackView




class AttendanceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attedance)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = resources.getString(R.string.attendance)
        supportActionBar?.elevation = 0f


        attendance_recycler_view.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        attendance_recycler_view.adapter =  AttendanceAdapter(this)


       progressInit()

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

    fun progressInit(){

        val startColors = resources.getStringArray(R.array.devlight)
        val bgColors = resources.getStringArray(R.array.medical_express)

        val models = ArrayList<ArcProgressStackView.Model>()
        models.add(ArcProgressStackView.Model("Present", 100f, Color.parseColor(bgColors[0]), Color.parseColor(startColors[0])))
        models.add(ArcProgressStackView.Model("Absent", 50f, Color.parseColor(bgColors[1]), Color.parseColor(startColors[1])))
        models.add(ArcProgressStackView.Model("Leaves", 70f, Color.parseColor(bgColors[2]), Color.parseColor(startColors[2])))

        progress_stack.models = models
    }
}

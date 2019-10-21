package com.labs.daphnis.iviewsmart

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.labs.daphnis.iviewsmart.Activity.AttendanceActivity.AttendanceActivity
import com.labs.daphnis.iviewsmart.Activity.BlogActivity.BlogActivity
import com.labs.daphnis.iviewsmart.Activity.PhotoGallery.PhotoGalleryActivity
import com.labs.daphnis.iviewsmart.Activity.TimeTable.TimeTableActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
*/
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        //toggle.drawerArrowDrawable.color = ContextCompat.getColor(this,R.color.white)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        val fragment = DashboardFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.content_ll, fragment)
        fragmentTransaction.commit()



        bottom_nav.setOnNavigationItemSelectedListener { p0 ->
            when (p0.itemId) {
                R.id.nav_home -> Toast.makeText(this@HomeActivity, "${p0.title}", Toast.LENGTH_SHORT).show()

                R.id.nav_profile -> Toast.makeText(this@HomeActivity, "${p0.title}", Toast.LENGTH_SHORT).show()

                R.id.nav_fund_box -> Toast.makeText(this@HomeActivity, "${p0.title}", Toast.LENGTH_SHORT).show()

                R.id.nav_commerce -> Toast.makeText(this@HomeActivity, "${p0.title}", Toast.LENGTH_SHORT).show()
            }
            true
        }



        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_notification -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_dashboard -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_Attendance -> {
                startActivity(Intent(this@HomeActivity,
                    AttendanceActivity::class.java))
            }

            R.id.nav_blog -> {
                startActivity(Intent(this@HomeActivity, BlogActivity::class.java))
            }

            R.id.nav_time_table ->{
                startActivity(Intent(this@HomeActivity,TimeTableActivity::class.java))
            }

            R.id.nav_revision -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_queries -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_gallery -> {
                startActivity(Intent(this@HomeActivity, PhotoGalleryActivity::class.java))
            }

            R.id.nav_result -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_Other -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onResume() {
        super.onResume()
        nav_view.setCheckedItem(R.id.nav_dashboard)
    }
}

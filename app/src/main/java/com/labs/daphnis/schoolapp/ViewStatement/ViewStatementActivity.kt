package com.labs.daphnis.schoolapp.ViewStatement

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.labs.daphnis.schoolapp.R
import kotlinx.android.synthetic.main.activity_view_statement.*

class ViewStatementActivity : AppCompatActivity() {

    private lateinit var mPagerAdapter: ViewStatementPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_statement)

        supportActionBar?.elevation = 0f

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.view_statement)

        mPagerAdapter = ViewStatementPagerAdapter(supportFragmentManager)
        view_pager?.adapter = mPagerAdapter

        tab_layout?.setupWithViewPager(view_pager)
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



class ViewStatementPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return StatementFragment.newInstance(pageTitle[position])
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return pageTitle[position]
    }

    companion object {
        val pageTitle by lazy {
            arrayListOf("All","Money In","Money Out")
        }
    }
}

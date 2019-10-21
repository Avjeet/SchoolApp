package com.labs.daphnis.iviewsmart.Activity.PhotoGallery

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.labs.daphnis.iviewsmart.R

class PhotoGalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_gallery)

        supportActionBar?.title = getString(R.string.photo_gallery)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val fragment = PhotoGridFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.gallery_container,fragment)
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {

                if(supportFragmentManager.backStackEntryCount==0){
                    finish()
                }else{
                    onBackPressed()
                }
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}

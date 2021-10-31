package com.veronica.idn.pokemonapplication.presentation.base

import android.view.MenuItem
import androidx.viewbinding.ViewBinding

abstract class BaseChildActivity<T : ViewBinding> : BaseActivity<T>() {
    override fun onStart() {
        super.onStart()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}
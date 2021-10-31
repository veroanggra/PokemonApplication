package com.veronica.idn.pokemonapplication.presentation.base

import android.content.Context
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.inputmethod.InputMethodManager
import androidx.viewbinding.ViewBinding
import com.veronica.idn.pokemonapplication.core.utils.ConnectivityReceiver
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

abstract class BaseActivity<T : ViewBinding> : DaggerAppCompatActivity(),
    PresentationInterface.View, ConnectivityReceiver.Callback {

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> T

    @Suppress("UNCHECKED_CAST")
    protected val binding: T
        get() = _binding as T

    @Inject
    lateinit var connectivityReceiver: ConnectivityReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setupPresenter()
    }

    abstract fun setupPresenter()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onStart() {
        super.onStart()
        connectivityReceiver.attachCallback(this)
        try {
            registerReceiver(
                connectivityReceiver,
                IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
            )
        } catch (e: IllegalArgumentException) {
            Timber.e(e)
        }
    }

    override fun onStop() {
        unregisterReceiver(connectivityReceiver)
        connectivityReceiver.detachCallback()
        super.onStop()
    }

    protected fun hideSoftKeyboard() {
        val imm: InputMethodManager =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }
}
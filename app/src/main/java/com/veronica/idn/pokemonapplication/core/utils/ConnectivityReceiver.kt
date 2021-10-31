package com.veronica.idn.pokemonapplication.core.utils

import android.content.Context
import android.content.Intent
import dagger.android.DaggerBroadcastReceiver
import javax.inject.Inject

class ConnectivityReceiver @Inject internal constructor(private val deviceUtil: DeviceUtil) :
    DaggerBroadcastReceiver() {

    private var callback: Callback? =
        null

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        val isNetworkConnected = deviceUtil.isOnline()
        if (callback != null) {
            callback!!.onConnectivityChanged(isNetworkConnected)
        }
    }

    fun attachCallback(callback: Callback?) {
        this.callback = callback
    }

    fun detachCallback() {
        this.callback = null
    }

    interface Callback {
        fun onConnectivityChanged(isOnline: Boolean)
    }

}
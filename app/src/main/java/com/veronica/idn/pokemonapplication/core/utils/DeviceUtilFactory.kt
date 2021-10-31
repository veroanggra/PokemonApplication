package com.veronica.idn.pokemonapplication.core.utils

import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.core.os.ConfigurationCompat
import com.veronica.idn.pokemonapplication.core.di.configuration.ApplicationContext
import java.util.*
import javax.inject.Inject


class DeviceUtilFactory @Inject internal constructor(@ApplicationContext private val context: Context) :
    DeviceUtil {

    override fun getConfigurationLocale(): Locale? =
        ConfigurationCompat.getLocales(context.resources.configuration).get(0)

    @SuppressWarnings("deprecation")
    override fun isOnline(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> {
                val cap = cm.getNetworkCapabilities(cm.activeNetwork) ?: return false
                return cap.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            }
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> {
                val networks = cm.allNetworks
                for (n in networks) {
                    val nInfo = cm.getNetworkInfo(n)
                    if (nInfo != null && nInfo.isConnected) return true
                }
            }
            else -> {
                val networks = cm.allNetworkInfo
                for (nInfo in networks) {
                    if (nInfo != null && nInfo.isConnected) return true
                }
            }
        }

        return false
    }

    override fun isLocationEnabled(): Boolean {
        val lm = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        var gpsEnabled = false
        var netWorkEnabled = false
        try {
            gpsEnabled = lm!!.isProviderEnabled(LocationManager.GPS_PROVIDER)
            netWorkEnabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return gpsEnabled && netWorkEnabled
    }
}
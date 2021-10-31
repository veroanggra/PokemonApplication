package com.veronica.idn.pokemonapplication.core.utils

import java.util.*

interface DeviceUtil {
    fun getConfigurationLocale(): Locale?
    fun isOnline(): Boolean
    fun isLocationEnabled(): Boolean
}
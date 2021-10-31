package com.veronica.idn.pokemonapplication.core.utils

import java.util.*

interface DataConverter {
    fun hashMD5(input: String): String
    fun formatCurrency(numb: Double, locale: Currency): CharSequence
    fun formatDate(timeMillis: Long, pattern: String): String
    fun toMillisDate(strDate: String, currentFormat: String): Long
    fun getResourceId(resourceName: String, resourceClassName: Class<*>): Int
    fun getResourceName(resourceId: Int): String
}
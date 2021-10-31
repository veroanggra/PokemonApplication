package com.veronica.idn.pokemonapplication.core.utils

import android.content.Context
import com.veronica.idn.pokemonapplication.core.di.configuration.ApplicationContext
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DataConverterFactory @Inject constructor(@ApplicationContext private val context: Context) :
    DataConverter {
    override fun hashMD5(input: String): String {
        return try {
            val md = MessageDigest.getInstance("MD5")
            val messageDigest = md.digest(input.toByteArray())
            val no = BigInteger(1, messageDigest)
            val hashText = StringBuilder(no.toString(16))
            while (hashText.length < 32) {
                hashText.insert(0, "0")
            }
            hashText.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
            throw RuntimeException(e)
        }
    }

    override fun formatCurrency(numb: Double, locale: Currency): CharSequence {
        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 0
        format.currency = locale
        return format.format(numb)
    }

    override fun formatDate(timeMillis: Long, pattern: String): String {
        return SimpleDateFormat(pattern, Locale.getDefault()).format(timeMillis)
    }

    override fun toMillisDate(strDate: String, currentFormat: String): Long {
        val df = SimpleDateFormat(currentFormat, Locale.UK)
        val d = df.parse(strDate)
        return d?.time ?: 0
    }

    inline fun <reified T : Class<*>> T.getId(resourceName: String): Int {
        return try {
            val idField = getDeclaredField(resourceName)
            idField.getInt(idField)
        } catch (e: Exception) {
            e.printStackTrace()
            -1
        }
    }

    override fun getResourceId(resourceName: String, resourceClassName: Class<*>): Int {
        return try {
            val idField = resourceClassName.getDeclaredField(resourceName)
            idField.getInt(idField)
        } catch (e: Exception) {
            e.printStackTrace()
            -1
        }
    }

    override fun getResourceName(resourceId: Int): String {
        return context.resources.getResourceEntryName(resourceId)
    }
}
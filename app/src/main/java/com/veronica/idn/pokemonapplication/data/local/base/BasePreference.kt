package com.veronica.idn.pokemonapplication.data.local.base

import android.content.SharedPreferences

abstract class BasePreference protected constructor(private val pref: SharedPreferences) {
    private fun edit(): SharedPreferences.Editor {
        return pref.edit()
    }

    /* GETTER */
    protected operator fun get(key: String, fallback: String): String {
        return pref.getString(key, fallback).toString()
    }
    protected operator fun set(key: String, value: String) {
        edit().putString(key, value).apply()
    }

}
package com.veronica.idn.pokemonapplication.data.base

interface DataMapper<S, D> {
    @Throws(Exception::class)
    fun fromData(data: D): S

    @Throws(Exception::class)
    fun toData(source: S): D
}
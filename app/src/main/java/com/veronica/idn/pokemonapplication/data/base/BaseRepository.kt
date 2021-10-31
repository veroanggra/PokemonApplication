package com.veronica.idn.pokemonapplication.data.base

abstract class BaseRepository<DATA_SOURCE> {
    protected var localData: DATA_SOURCE
    protected var remoteData: DATA_SOURCE? = null

    constructor(localData: DATA_SOURCE, remoteData: DATA_SOURCE) {
        this.localData = localData
        this.remoteData = remoteData
    }

    constructor(localData: DATA_SOURCE) {
        this.localData = localData
    }

    protected fun remoteDataSourceEmpty() = remoteData == null

}
package com.veronica.idn.pokemonapplication.domain.base

data class Result<out T> internal constructor(val status: Status, internal val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?, message: String?): Result<T> =
            Result(Status.SUCCESS, data, message)

        fun <T> error(message: String, data: T?): Result<T> = Result(Status.ERROR, data, message)

        fun <T> loading(message: String?): Result<T> = Result(Status.LOADING, null, message)
    }
}

enum class Status { SUCCESS, ERROR, LOADING }
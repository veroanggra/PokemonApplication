package com.veronica.idn.pokemonapplication.domain.base

data class BaseResult<out T>(
    val errorCode: String,
    val isError: Boolean,
    val message: String,
    val data: T?
)
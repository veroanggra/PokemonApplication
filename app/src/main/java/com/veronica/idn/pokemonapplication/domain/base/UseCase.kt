package com.veronica.idn.pokemonapplication.domain.base

interface UseCase<RESULT, PARAM> {
    fun execute(param: PARAM): RESULT
}
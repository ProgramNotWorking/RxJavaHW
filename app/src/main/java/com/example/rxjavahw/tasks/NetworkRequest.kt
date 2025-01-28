package com.example.rxjavahw.tasks

import android.annotation.SuppressLint
import com.example.rxjavahw.tasks.RequestResult.Success
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

@SuppressLint("CheckResult")
fun main() {

    /** Задача:
     *  сделать сетевой запрос и отобразить результат на экране
     * **/

    sendRequestAndGetResult()
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.computation())
        .subscribe({ result ->
            when(result) {
                is RequestResult.Success -> {
                    println("Данные получены: ${result.data}")
                }
                is RequestResult.Error -> {
                    println("Ошибка: ${result.throwable?.message}")
                }
            }
        }, { error ->
            println("Ошибка при выполнении запроса: ${error.message}")
        })

    Thread.sleep(1000)

}

// Имитация запроса в сеть
fun sendRequestAndGetResult(): Single<RequestResult<String>> =
    Single.fromCallable {
        Thread.sleep(100)
        Success("Some data")
    }

sealed interface RequestResult <T> {

    data class Success<T>(
        val data: T
    ) : RequestResult<T>

    data class Error<T>(
        val throwable: Throwable? = null
    ) : RequestResult<T>

}
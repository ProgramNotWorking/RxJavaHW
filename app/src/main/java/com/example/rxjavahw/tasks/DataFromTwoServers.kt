package com.example.rxjavahw.tasks

import android.annotation.SuppressLint
import io.reactivex.rxjava3.core.Observable
import kotlin.random.Random

fun main() {

    /**
     * Задача:
     * Есть 2 сервера на которых лежат скидочные карты.
     * Нужно получить эти данные и вывести в единый список
     * **/

    getCombinedDataDespiteTheRequestFailure()
    getCombinedDataIfRequestSuccessful()

}

// Функция для получения данных, даже если запросы падают (пункт а задачи)
@SuppressLint("CheckResult")
fun getCombinedDataDespiteTheRequestFailure() {
    Observable.zip(
        getDataFromFirstServer().onErrorReturn { RequestResult.Error(it) },
        getDataFromSecondServer().onErrorReturn { RequestResult.Error(it) }
    ) { firstData, secondData ->
        when (firstData) {
            is RequestResult.Success -> {
                when (secondData) {
                    is RequestResult.Success -> firstData.data + secondData.data
                    is RequestResult.Error -> {
                        println(secondData.throwable?.message)
                        firstData.data
                    }
                }
            }

            is RequestResult.Error -> {
                println(firstData.throwable?.message)
                when (secondData) {
                    is RequestResult.Success -> secondData.data
                    is RequestResult.Error -> {
                        println(secondData.throwable?.message)
                        emptyList()
                    }
                }
            }
        }
    }
        .subscribe { combinedList ->
            println(combinedList)
        }
}

// Функция для получения данных, если оба запроса выполнены (пункт б задачи)
@SuppressLint("CheckResult")
fun getCombinedDataIfRequestSuccessful() {
    Observable.zip(
        getDataFromFirstServer(),
        getDataFromSecondServer()
    ) { firstData, secondData ->
        when {
            firstData is RequestResult.Success && secondData is RequestResult.Success -> {
                firstData.data + secondData.data
            }

            else -> throw Exception("One of the request failed")
        }
    }
        .onErrorComplete()
        .subscribe(
            { combinedList -> println(combinedList) },
            { error -> println("Error: ${error.message}") }
        )
}

// Имитация получения данных с первого сервера
fun getDataFromFirstServer(): Observable<RequestResult<List<DiscountCard>>> {
    Thread.sleep(500)
    return Observable.just(
        if (Random.nextBoolean()) {
            RequestResult.Success(
                listOf(
                    DiscountCard("Bob", 1000),
                    DiscountCard("Tom", 500),
                    DiscountCard("Sarah", 700),
                    DiscountCard("Sam")
                )
            )
        } else {
            RequestResult.Error(Exception("Something wrong with first server"))
        }
    )
}

// Имитация получения данных со второго сервера
fun getDataFromSecondServer(): Observable<RequestResult<List<DiscountCard>>> {
    Thread.sleep(500)
    return Observable.just(
        if (Random.nextBoolean()) {
            RequestResult.Success(
                listOf(
                    DiscountCard("Samuel", 100),
                    DiscountCard("Alexa", 800),
                    DiscountCard("Sandy"),
                    DiscountCard("Immanuel", 250)
                )
            )
        } else {
            RequestResult.Error(Exception("Something wrong with second server"))
        }
    )
}

data class DiscountCard(
    val owner: String,
    val balance: Int? = null
)
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

    getCombinedData()

}

@SuppressLint("CheckResult")
fun getCombinedData() {

    Observable.zip(
        getDataFromFirstServer(), getDataFromSecondServer()
    ) { firstData, secondData ->
        when (firstData) {
            is RequestResult.Success -> {
                when (secondData) {
                    is RequestResult.Success -> firstData.data + secondData.data
                    is RequestResult.Error -> firstData.data
                }
            }
            is RequestResult.Error -> {
                when (secondData) {
                    is RequestResult.Success -> secondData.data
                    is RequestResult.Error -> emptyList()
                }
            }
        }
    }
        .subscribe { combinedList ->
            println(combinedList)
        }
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
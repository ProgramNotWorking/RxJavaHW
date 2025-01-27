package com.example.rxjavahw.tests

import android.annotation.SuppressLint
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

@SuppressLint("CheckResult")
fun main() {

    val disposable = Observable.interval(1, TimeUnit.SECONDS)
        .subscribe { println("Get: $it") }

// Отписываемся через 5 секунд
    Thread.sleep(5000)
    disposable.dispose()
    println("Subscrition cancelled")

}
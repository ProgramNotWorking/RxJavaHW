package com.example.rxjavahw.tasks

import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject

fun main() {

    /**   Изначальный код
    //    val subject = PublishSubject.create<String>()
    //    subject.onNext("1")
    //    subject.onNext("2")
    //    subject.onNext("3")
    //    subject.subscribe { println(it) }
     **/

    // Исправленный код (1-й вариант)
    val subject = PublishSubject.create<String>()
    subject.subscribe { println(it) }
    subject.onNext("1")
    subject.onNext("2")
    subject.onNext("3")

    // Исправленный код (2-й вариант)
    val test = ReplaySubject.create<String>()
    test.onNext("1")
    test.onNext("2")
    test.onNext("3")
    test.subscribe { println(it) }

}
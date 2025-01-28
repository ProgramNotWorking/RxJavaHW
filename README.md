## Задача на исправление кода с PublishSubject - [Task1](https://github.com/ProgramNotWorking/RxJavaHW/blob/master/app/src/main/java/com/example/rxjavahw/tasks/Task1.kt)
Исправить данный код 2-мя способами
```kotlin
    val subject = PublishSubject.create<String>()
    subject.onNext("1")
    subject.onNext("2")
    subject.onNext("3")
    subject.subscribe { println(it) }
```

## Задача на сетевой запрос и отображение результата - [NetworkRequest](https://github.com/ProgramNotWorking/RxJavaHW/blob/master/app/src/main/java/com/example/rxjavahw/tasks/NetworkRequest.kt)
Сделать сетевой запрос и отобразить результат на экране

## Задача на таймер, меняющий TextView - [TimerActivity](https://github.com/ProgramNotWorking/RxJavaHW/blob/master/app/src/main/java/com/example/rxjavahw/tasks/TimerActivity.kt)
Сделать таймер. TextView которая раз в секунду меняется

## Задача на ресайклер и передачу данных из него - [содержимое папки recycler_and_fragment](https://github.com/ProgramNotWorking/RxJavaHW/tree/master/app/src/main/java/com/example/rxjavahw/tasks/recycler_and_fragment)
Сделать ресайклер. 
По нажатию на элемент передавайть его позицию во фрагмент и во фрагменте этот номер отображать в тосте

## Задача на вывод информации в логи, если в EditText ничего не вводится 3 секунды - [EditTextActivity](https://github.com/ProgramNotWorking/RxJavaHW/blob/master/app/src/main/java/com/example/rxjavahw/tasks/EditTextActivity.kt)
Сделать EditText. 
При наборе текста выводить в лог содержимое EditText всегда, когда пользователь 3 секунды что-то не вводил

## Задача на запрос на 2 сервера и отображение объединенных данных с них - [DataFromTwoServers](https://github.com/ProgramNotWorking/RxJavaHW/blob/master/app/src/main/java/com/example/rxjavahw/tasks/DataFromTwoServers.kt)
Есть 2 сервера на которых лежат скидочные карты.
Нужно получить эти данные и вывести в единый список
* Если 1 из запросов падает, то все равно выводить
* Если 1 из запросов падает, то не выводить ничего

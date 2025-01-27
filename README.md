## [Задача](https://github.com/ProgramNotWorking/RxJavaHW/blob/master/app/src/main/java/com/example/rxjavahw/tasks/Task1.kt) на исправление кода с PublishSubject - `Task1`
Исправить данный код 2-мя способами
```kotlin
    val subject = PublishSubject.create<String>()
    subject.onNext("1")
    subject.onNext("2")
    subject.onNext("3")
    subject.subscribe { println(it) }
```

## [Задача](https://github.com/ProgramNotWorking/RxJavaHW/blob/master/app/src/main/java/com/example/rxjavahw/tasks/NetworkRequest.kt) на сетевой запрос и отображение результата - `NetworkRequest`
Сделать сетевой запрос и отобразить результат на экране

## [Задача](https://github.com/ProgramNotWorking/RxJavaHW/blob/master/app/src/main/java/com/example/rxjavahw/tasks/TimerActivity.kt) на таймер, меняющий TextView - `TimerActivity`
Сделать таймер. TextView которая раз в секунду меняется

## [Задача](https://github.com/ProgramNotWorking/RxJavaHW/tree/master/app/src/main/java/com/example/rxjavahw/tasks/recycler_and_fragment) на ресайклер и передачу данных из него - `содержимое папки recycler_and_fragment`
Сделать ресайклер. 
По нажатию на элемент передавайть его позицию во фрагмент и во фрагменте этот номер отображать в тосте

## [Задача](https://github.com/ProgramNotWorking/RxJavaHW/blob/master/app/src/main/java/com/example/rxjavahw/tasks/EditTextActivity.kt) на вывод информации в логи, если в EditText ничего не вводится 3 секунды - `EditTextActivity`
Сделать EditText. 
При наборе текста выводить в лог содержимое EditText всегда, когда пользователь 3 секунды что-то не вводил

## [Задача](https://github.com/ProgramNotWorking/RxJavaHW/blob/master/app/src/main/java/com/example/rxjavahw/tasks/DataFromTwoServers.kt) на запрос на 2 сервера и отображение объединенных данных с них - `DataFromTwoServers`
Есть 2 сервера на которых лежат скидочные карты.
Нужно получить эти данные и вывести в единый список
* Если 1 из запросов падает, то все равно выводить
* Если 1 из запросов падает, то не выводить ничего

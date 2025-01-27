package com.example.rxjavahw.tasks

import android.app.Activity
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsCompat.Type.ime
import androidx.core.widget.addTextChangedListener
import com.example.rxjavahw.R
import com.example.rxjavahw.databinding.ActivityEditTextBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class EditTextActivity : AppCompatActivity() {

    /** Задача: сделать EditText.
     * При наборе текста выводить в лог содержимое EditText всегда,
     * когда пользователь 3 секунды что-то не вводил
     * **/

    private lateinit var binding: ActivityEditTextBinding

    private val disposables = CompositeDisposable()
    private val textSubject = PublishSubject.create<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditTextBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.editTextView.addTextChangedListener { text ->
            textSubject.onNext(text.toString())
        }

        val disposable = textSubject
            .debounce(3, TimeUnit.SECONDS)
            .distinctUntilChanged()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ text ->
                Log.d("EDITTEXT", "Текст после паузы: $text")
            }, { error ->
                Log.d("EDITTEXT", "Ошибка: ${error.message}")
            })

        disposables.add(disposable)

    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_DOWN) {
            val focus = currentFocus
            if (focus is EditText) {
                val outRect = Rect()
                focus.getGlobalVisibleRect(outRect)
                if (!outRect.contains(ev.rawX.toInt(), ev.rawY.toInt())) {
                    KeyboardUtils.hideKeyboard(this, binding.rootView)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}

object KeyboardUtils {
    fun hideKeyboard(activity: Activity, view: View) {
        WindowCompat.getInsetsController(activity.window, view).hide(ime())
    }
}
package com.example.rxjavahw.tasks.recycler_and_fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rxjavahw.R
import com.example.rxjavahw.databinding.ActivityRecyclerBaseBinding

class RecyclerBaseActivity : AppCompatActivity() {

    /** Задача:
     *  Сделайть ресайклер. По нажатию на элемент передавать его позицию во фрагмент
     *  и во фрагменте этот номер отображайть в тосте.
     * **/

    private lateinit var binding: ActivityRecyclerBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecyclerBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
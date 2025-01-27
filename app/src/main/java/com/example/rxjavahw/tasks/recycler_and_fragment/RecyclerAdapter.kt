package com.example.rxjavahw.tasks.recycler_and_fragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavahw.R
import com.example.rxjavahw.databinding.RecyclerItemBinding
import io.reactivex.rxjava3.subjects.PublishSubject

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val itemsList = ItemsUtil.getItemsList()
    val itemClickSubject = PublishSubject.create<Int>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RecyclerItemBinding.bind(view)

        @SuppressLint("SetTextI18n")
        fun bind() = with(binding) {
            itemNumberTextView.text = (adapterPosition + 1).toString()
            recyclerItemHolder.setOnClickListener {
                itemClickSubject.onNext(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_item, parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

}
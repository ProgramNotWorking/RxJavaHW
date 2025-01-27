package com.example.rxjavahw.tasks.recycler_and_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rxjavahw.databinding.RecyclerFragmentBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

class RecyclerFragment : Fragment() {

    private lateinit var binding: RecyclerFragmentBinding
    private val adapter = RecyclerAdapter()
    private val disposables = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RecyclerFragmentBinding.inflate(layoutInflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposables.clear()
    }

    private fun setupRecyclerView() = binding.apply {
        val disposable = adapter.itemClickSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { position ->
                Toast.makeText(
                    requireContext(),
                    "Clicked on item with ${position + 1} position",
                    Toast.LENGTH_SHORT
                ).show()
            }

        disposables.add(disposable)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
    }

}
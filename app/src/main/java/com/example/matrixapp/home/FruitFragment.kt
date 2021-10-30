package com.example.matrixapp.home

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.matrixapp.DetailsActivity
import com.example.matrixapp.MainActivity
import com.example.matrixapp.R
import com.example.matrixapp.adapters.FruitAdapter
import com.example.matrixapp.model.Fruit
import com.example.matrixapp.model.FruitList
import android.app.Activity

import android.app.ActivityOptions
import com.example.matrixapp.constants.*


class FruitFragment : Fragment() {

    lateinit var fruitAdapter: FruitAdapter
    lateinit var recyclerView: RecyclerView
    companion object {
        fun newInstance() = FruitFragment()
    }

    private lateinit var viewModel: FruitsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fruit_fragment, container, false)

        initializeViews(view)
        loadFruitsFromViewModel()

        return view
    }

    private fun loadFruitsFromViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(FruitsViewModel::class.java)
        viewModel.getRecyclerListLiveData().observe(viewLifecycleOwner, { fruitList ->
            if (fruitList != null) {
                fruitAdapter = FruitAdapter(fruitList.fruits as ArrayList<Fruit>) { fruit ->
                    showFruitDetails(fruit)
                }
                recyclerView.adapter = fruitAdapter
            } else
                Toast.makeText(activity, getString(R.string.error_getting_data), Toast.LENGTH_SHORT).show()
        })
        viewModel.loadFruits()
    }


    private fun initializeViews(view: View){
        recyclerView = view.findViewById(R.id.fruits_rv)
        recyclerView.layoutManager = GridLayoutManager(activity,2)
        recyclerView.setHasFixedSize(true)
    }

    private fun showFruitDetails(fruit: Fruit){
        val intent = Intent(context,DetailsActivity::class.java)
        intent.putExtra(FRUIT_NAME_EXTRA, fruit.name);
        intent.putExtra(FRUIT_IMAGE_EXTRA, fruit.imageUrl);
        intent.putExtra(FRUIT_DESCRIPTION_EXTRA, fruit.description);
        intent.putExtra(FRUIT_PRICE_EXTRA, fruit.price);

        startActivity(intent)
    }

}
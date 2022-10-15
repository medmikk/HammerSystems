package com.example.hammersystems.ui.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hammersystems.R
import com.example.hammersystems.ui.adapters.BannerAdapter
import com.example.hammersystems.ui.adapters.CategoryAdapter
import com.example.hammersystems.ui.adapters.PizzaAdapter
import com.example.hammersystems.databinding.FragmentMenuBinding
import com.example.hammersystems.utils.Resource
import com.example.hammersystems.ui.activity.MainActivity
import com.example.hammersystems.ui.viewmodel.MenuViewModel

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var viewModel: MenuViewModel
    private lateinit var binding: FragmentMenuBinding
    private lateinit var pizzaAdapter: PizzaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        setupBanners()
        setupCategories()
        setupPizza()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).menuViewModel

        viewModel.pizzaList.observe(viewLifecycleOwner){
            response ->
            when(response){
                is Resource.Success -> {
                    binding.progressbar.visibility = View.INVISIBLE
                    response.data?.let { pizzaResponse ->
                        pizzaAdapter.differ.submitList(pizzaResponse)
                    }
                }
                is Resource.Error -> {
                    binding.progressbar.visibility = View.INVISIBLE
                    response.message?.let{message->
                        Log.e(TAG, "Error occured: $message")
                    }
                }
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun setupBanners(){
        val images = listOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3)
        binding.bannerRV.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        binding.bannerRV.adapter = BannerAdapter(images)
    }

    private fun setupCategories(){
        val categories = listOf("Пицца","Комбо","Десерты","Напитки","Акции")
        binding.categoriesRV.apply{
            layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = CategoryAdapter(categories)


        }

    }

    private fun setupPizza(){
        pizzaAdapter = PizzaAdapter()
        binding.pizzaRV.adapter = pizzaAdapter
        binding.pizzaRV.layoutManager = LinearLayoutManager(activity)
    }

}
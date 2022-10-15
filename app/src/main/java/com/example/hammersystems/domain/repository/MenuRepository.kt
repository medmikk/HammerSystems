package com.example.hammersystems.domain.repository

import com.example.hammersystems.data.network.RetrofitInstance
import com.example.hammersystems.domain.model.Pizza
import com.example.hammersystems.utils.Constants

interface MenuRepository {

    suspend fun getPizzaList(query: String, number: Int): ArrayList<Pizza>
}
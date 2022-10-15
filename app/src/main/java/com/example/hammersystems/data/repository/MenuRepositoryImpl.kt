package com.example.hammersystems.data.repository

import com.example.hammersystems.data.network.RetrofitInstance
import com.example.hammersystems.domain.repository.MenuRepository
import com.example.hammersystems.utils.Constants

class MenuRepositoryImpl : MenuRepository {

    override suspend fun getPizzaList(query: String, number: Int) =
        RetrofitInstance.retrofit.getPizzas(Constants.API_KEY, query, number).menuItems
}
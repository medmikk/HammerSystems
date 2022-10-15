package com.example.hammersystems.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hammersystems.domain.model.Pizza
import com.example.hammersystems.data.repository.MenuRepositoryImpl
import com.example.hammersystems.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MenuViewModel(
    val menuRepository : MenuRepositoryImpl
    ) : ViewModel() {

    val pizzaList: MutableLiveData<Resource<List<Pizza>>> = MutableLiveData()

    init {
        getPizzaList("pizza", 15)
    }

    fun getPizzaList(query: String, number: Int) = viewModelScope.launch {
        pizzaList.postValue(Resource.Loading())

        var response: ArrayList<Pizza>?
        //простите, я не специально. нет времени разбираться, что я пропустил в хендлере
        //TODO сделать нормалльный хендлер
        try {
            response = menuRepository.getPizzaList(query, number)
        } catch(ex : IOException){
            response = null
        }
        pizzaList.postValue(handlePizza(response))

    }

    private fun handlePizza(response: List<Pizza>?): Resource<List<Pizza>> {
        response?.let{ resultResponse ->

            return Resource.Success(resultResponse)
        }
        return Resource.Error("null array")
    }
}
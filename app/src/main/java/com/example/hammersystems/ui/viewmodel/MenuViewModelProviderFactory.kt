package com.example.hammersystems.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hammersystems.data.repository.MenuRepositoryImpl

class MenuViewModelProviderFactory (
    val menuRepository: MenuRepositoryImpl
        ): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MenuViewModel(menuRepository) as T
    }
}
package com.example.hammersystems.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hammersystems.R
import com.example.hammersystems.data.repository.MenuRepositoryImpl
import com.example.hammersystems.domain.repository.MenuRepository
import com.example.hammersystems.ui.fragments.BasketFragment
import com.example.hammersystems.ui.fragments.MenuFragment
import com.example.hammersystems.ui.fragments.ProfileFragment
import com.example.hammersystems.ui.viewmodel.MenuViewModel
import com.example.hammersystems.ui.viewmodel.MenuViewModelProviderFactory
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var menuViewModel: MenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        val bottomNavigation : BottomNavigationView = findViewById(R.id.bottom_navigation)

        val menuRepository = MenuRepositoryImpl()
        val viewModelProviderFactory = MenuViewModelProviderFactory(menuRepository)
        menuViewModel = ViewModelProvider(this, viewModelProviderFactory).get(MenuViewModel::class.java)

        val menuFragment = MenuFragment()
        val profileFragment = ProfileFragment()
        val basketFragment = BasketFragment()


        makeFragment(menuFragment)

        bottomNavigation.setOnItemSelectedListener{
            when (it.itemId){
                R.id.ic_menu -> makeFragment(menuFragment)
                R.id.ic_profile -> makeFragment(profileFragment)
                R.id.ic_basket -> makeFragment(basketFragment)
            }
            true
        }
    }
    private fun makeFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}
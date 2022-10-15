package com.example.hammersystems.domain.model

import com.google.gson.annotations.SerializedName

data class ApiResponse (
    @SerializedName("type"             ) var type             : String?              = null,
    @SerializedName("menuItems"        ) var menuItems        : ArrayList<Pizza> = arrayListOf(),
    @SerializedName("isStale"          ) var isStale          : Boolean?             = null
        )
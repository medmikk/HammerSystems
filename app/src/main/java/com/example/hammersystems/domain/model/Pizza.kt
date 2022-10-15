package com.example.hammersystems.domain.model

import com.google.gson.annotations.SerializedName

data class Pizza(
    @SerializedName("id"                  ) var id                  : Int?      = null,
    @SerializedName("title"               ) var title               : String?   = null,
    @SerializedName("image"               ) var image               : String?   = null,
    @SerializedName("restaurantChain"     ) var restaurantChain     : String?   = null
)
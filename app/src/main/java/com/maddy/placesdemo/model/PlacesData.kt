package com.maddy.placesdemo.model

import com.google.gson.annotations.SerializedName

data class PlacesData(
    @SerializedName("addressList")
    val addressList: ArrayList<Address>,
    @SerializedName("autoCompleteRequestString")
    val autoCompleteRequestString: String

){

    data class Address(
        @SerializedName("id")
        val id: String,
        @SerializedName("pinCode")
        val pinCode: String,
        @SerializedName("city")
        val city: String,
        @SerializedName("cityBoundaryBreached")
        val cityBoundaryBreached: Boolean,
        @SerializedName("pinCodeBoundaryBreached")
        val pinCodeBoundaryBreached: Boolean,
        @SerializedName("addressType")
        val addressType: String,
        @SerializedName("addressString")
        val addressString: String,
        @SerializedName("latitude")
        val latitude: Double,
        @SerializedName("longitude")
        val longitude: Double,
        @SerializedName("errorMargin")
        val errorMargin: Int
    )

}

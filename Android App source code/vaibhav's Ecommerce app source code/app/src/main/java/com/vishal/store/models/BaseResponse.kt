package com.vishal.store.models

import com.google.gson.annotations.SerializedName

open class BaseResponse(val message: String? = null)

open class Card {
    @SerializedName("card_img")
    var cardImg: Int? = null
    @SerializedName("card_type")
    var cardType: String? = null

    @SerializedName("bank_name")
    var bankName: String? = null

    @SerializedName("card_number")
    var cardNumber: String? = null

    @SerializedName("valid_date")
    var validDate: String? = null

    @SerializedName("holder_name")
    var holderName: String? = null
}


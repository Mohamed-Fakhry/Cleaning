package alif.hamza.moquette.model

import com.google.gson.annotations.SerializedName


class OrderCart {

    @SerializedName("payment")
    var paymentType = "cash"
    var location: Location? = null
    var carpets: MutableList<Carpet>? = null
    var price: Double = 0.0
    lateinit var typeOfService: Price
    var createdAt = ""
    lateinit var status: MutableList<Status>
}

data class Status(var display: String, var state: Boolean)
package alif.hamza.moquette.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Order : Serializable {

    @SerializedName("payment")
    var paymentType = "cash"
    var location: Location? = null
    var carpets: MutableList<Carpet>? = null
    var prices: MutableList<Price>? = null
    var typeOfService: String? = null

    override fun toString(): String {
        return "Order(paymentType='$paymentType', location=$location, carpets=$carpets, prices=$prices)"
    }
}

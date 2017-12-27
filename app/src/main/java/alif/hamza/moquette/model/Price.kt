package alif.hamza.moquette.model

import java.io.Serializable

data class Price(var id: String, var priceOfMeter: Double, var typeOfService: String,var selected: Boolean = false): Serializable
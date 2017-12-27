package alif.hamza.moquette.model

import com.google.android.gms.maps.model.LatLng

import java.io.Serializable

class Location : Serializable {

    var latLng: LatLng? = null
    var lang: String? = null
    var lat: String? = null
    var street: String? = null

    constructor(latLng: LatLng) {
        this.latLng = latLng
        this.lang = latLng.longitude.toString()
        this.lat = latLng.latitude.toString()
    }

    constructor(latLng: LatLng, street: String) {
        this.latLng = latLng
        this.street = street
    }

    override fun toString(): String {
        return "Location(latLng=$latLng, lang=$lang, lat=$lat, street=$street)"
    }
}

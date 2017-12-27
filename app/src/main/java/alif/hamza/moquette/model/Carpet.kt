package alif.hamza.moquette.model

import java.io.Serializable

class Carpet(var number: Int, var width: String?, var height: String?, var size: Double = width!!.toDouble() * height!!.toDouble())
    : Serializable {

    override fun toString(): String {
        return "Carpet(size=$size)"
    }
}

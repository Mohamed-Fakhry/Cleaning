package alif.hamza.moquette.service.model.map

import alif.hamza.moquette.model.Order
import alif.hamza.moquette.model.Price


interface MapModel {

    interface OnGetPrices {
        fun onSucess(prices: MutableList<Price>)
        fun onFail()
    }

    interface OnPostOrder {
        fun onSucess(prices: MutableList<Price>)
        fun onFail()
    }

    fun getPrices(listener: OnGetPrices)

    fun postOrder(order: Order,listener: OnPostOrder )
}
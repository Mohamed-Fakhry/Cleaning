package alif.hamza.moquette.service.model.cart

import alif.hamza.moquette.model.OrderCart

interface CartModel {

    interface OnGetOrders {
        fun onSucess(prices: MutableList<OrderCart>)
        fun onFail()
    }

    fun getOrders(listener: OnGetOrders)
}
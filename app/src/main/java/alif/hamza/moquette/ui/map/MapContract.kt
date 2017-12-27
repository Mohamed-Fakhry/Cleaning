package alif.hamza.moquette.ui.map

import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView

import alif.hamza.moquette.model.Order
import alif.hamza.moquette.model.Price

interface MapContract {
    interface View : MvpView {
        fun confirmOrder()
        fun getPrices(prices: MutableList<Price>)
    }

    interface Presenter<V: View> : MvpPresenter<V> {
        fun getPrices()
        fun makeOrder(order: Order)
    }
}

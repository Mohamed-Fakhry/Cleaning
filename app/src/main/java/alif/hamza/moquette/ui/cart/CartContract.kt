package alif.hamza.moquette.ui.cart

import com.example.computec.eltadreb.ui.base.MvpPresenter
import com.example.computec.eltadreb.ui.base.MvpView
import alif.hamza.moquette.model.OrderCart

interface CartContract {

    interface View : MvpView {
        fun showOrders(orders: MutableList<OrderCart>)
    }

    interface Presenter<V: View>: MvpPresenter<V> {
        fun getOrders()
    }
}

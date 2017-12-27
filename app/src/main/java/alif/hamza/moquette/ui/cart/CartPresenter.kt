package alif.hamza.moquette.ui.cart


import com.example.computec.eltadreb.ui.base.BasePresenter
import alif.hamza.moquette.model.OrderCart
import alif.hamza.moquette.service.model.cart.CartModel
import alif.hamza.moquette.service.model.cart.CartModelImpl

class CartPresenter<V : CartContract.View> : BasePresenter<V>(),
        CartContract.Presenter<V>, CartModel.OnGetOrders {

    var cartModel: CartModel = CartModelImpl()

    override fun getOrders() {
        cartModel.getOrders(this)
    }

    override fun onSucess(orders: MutableList<OrderCart>) {
        mvpView?.showOrders(orders)
    }

    override fun onFail() {

    }
}

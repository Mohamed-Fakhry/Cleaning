package alif.hamza.moquette.ui.cart


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.computec.eltadreb.ui.base.BaseFragment
import alif.hamza.moquette.R
import alif.hamza.moquette.model.Order
import alif.hamza.moquette.model.OrderCart
import alif.hamza.moquette.ui.cart.adapter.OrdersAdapter
import kotlinx.android.synthetic.main.fragment_cart.*


class CartFragment : BaseFragment(), CartContract.View {

    lateinit var ordersAdapter: OrdersAdapter
    lateinit var orders: MutableList<Order>
    lateinit var cartPresenter: CartContract.Presenter<CartFragment>

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_cart, container, false)
        setUp(view)
        return view
    }

    override fun setUp(view: View?) {
        activity.title = "طلباتى"
        cartPresenter = CartPresenter<CartFragment>()
        cartPresenter.onAttach(this)
        cartPresenter.getOrders()
    }

    companion object {

        fun newInstance(): CartFragment {
            val fragment = CartFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun showOrders(orders: MutableList<OrderCart>) {
        ordersAdapter = OrdersAdapter(orders)
        ordersRV.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        ordersRV!!.adapter = ordersAdapter
        Log.d("orders", orders.size.toString())
    }
}

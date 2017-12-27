package alif.hamza.moquette.ui.cart.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.LinearLayout
import alif.hamza.moquette.R
import alif.hamza.moquette.model.OrderCart

class OrdersAdapter(var orders: MutableList<OrderCart>) : RecyclerView.Adapter<OrderVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderVH {
        return OrderVH(LinearLayout.inflate(parent.context, R.layout.item_order_cart, null))
    }

    override fun onBindViewHolder(holder: OrderVH, position: Int) {
        holder.setOrder(orders[position])
    }

    override fun getItemCount(): Int {
        return orders.size
    }
}

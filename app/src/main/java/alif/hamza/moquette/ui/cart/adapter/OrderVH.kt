package alif.hamza.moquette.ui.cart.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import alif.hamza.moquette.R
import alif.hamza.moquette.model.OrderCart
import kotlinx.android.synthetic.main.item_order_cart.view.*


class OrderVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var order: OrderCart? = null


    fun setOrder(order: OrderCart) {
        this.order = order
        with(itemView) {
            serviceTypeTV.text = order.typeOfService.typeOfService
            paymentTypeTV.text = order.paymentType
            dateTV.text = order.createdAt.subSequence(0, 10)
            priceTV.text = order.price.toString()

            fistStepTV.text = order.status[0].display
            secondStepTV.text = order.status[1].display
            thirdStepTV.text = order.status[2].display
            forthStepTV.text = "Completed"

            if (order.status[0].state) {
                fistStepLineV.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
                fistStepCV.setBackgroundResource(R.drawable.bg_steps)
                fistStepTV.setTextColor(ContextCompat.getColor(context, R.color.colorAccent))
            }

            if (order.status[1].state) {
                secondStepLineV.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
                secondStepCV.setBackgroundResource(R.drawable.bg_steps)
                secondStepTV.setTextColor(ContextCompat.getColor(context, R.color.colorAccent))
            }

            if (order.status[2].state) {
                thirdStepLineV.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
                thirdStepCV.setBackgroundResource(R.drawable.bg_steps)
                thirdStepTV.setTextColor(ContextCompat.getColor(context, R.color.colorAccent))
            }

            if (order.status[3].state) {
                itemView.visibility = View.GONE
            }
        }
    }
}

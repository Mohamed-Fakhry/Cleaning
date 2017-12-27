package alif.hamza.moquette.ui.cart.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import alif.hamza.moquette.R
import alif.hamza.moquette.model.Notifiction

class NotificationAdapter(var notifitcations: MutableList<Notifiction>) : RecyclerView.Adapter<NotificationVH>() {

    override fun getItemViewType(position: Int): Int {
        return position
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationVH {
        return if (viewType == notifitcations.size - 1) {
            NotificationVH(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_notification_bottom, null))
        } else {
            NotificationVH(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_notification, null))
        }
    }

    override fun onBindViewHolder(holder: NotificationVH, position: Int) {
        holder.setNotificationView(notifitcations[position])
    }

    override fun getItemCount(): Int {
        return notifitcations.size
    }
}

package alif.hamza.moquette.ui.cart.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView
import alif.hamza.moquette.R
import alif.hamza.moquette.model.Notifiction


class NotificationVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setNotificationView(notifiction: Notifiction) {
        with(itemView, {
            val bodyTV = findViewById<TextView>(R.id.bodyTV)
            bodyTV.text = notifiction.message
            Log.d("test", notifiction.message + notifiction)
        })
    }
}

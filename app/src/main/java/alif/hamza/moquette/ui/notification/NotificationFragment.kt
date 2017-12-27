package alif.hamza.moquette.ui.notification

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.computec.eltadreb.ui.base.BaseFragment
import alif.hamza.moquette.R
import alif.hamza.moquette.model.Notifiction
import alif.hamza.moquette.ui.cart.adapter.NotificationAdapter
import kotlinx.android.synthetic.main.fragment_notification.*

class NotificationFragment : BaseFragment(), NotifictionContract.View {

    lateinit var notificationPresenter: NotifictionContract.Presenter<NotificationFragment>
    lateinit var notificationAdapter: NotificationAdapter

    companion object {
        fun newInstance(): NotificationFragment = NotificationFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_notification, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(null)
    }

    override fun setUp(view: View?) {
        activity.title = "الاشعارات"
        notificationPresenter = NotificationPresenter()
        notificationPresenter.onAttach(this)
        notificationPresenter.getNotifictions()
    }

    override fun showNotifictions(notifications: MutableList<Notifiction>) {
        notificationAdapter = NotificationAdapter(notifications)
        notificationRV.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        notificationRV!!.adapter = notificationAdapter
        Log.d("orders", notifications.size.toString())
    }
}
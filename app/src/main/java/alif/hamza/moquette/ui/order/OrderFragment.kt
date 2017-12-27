package alif.hamza.moquette.ui.order

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.ButterKnife
import com.example.computec.eltadreb.ui.base.BaseFragment
import alif.hamza.moquette.R
import alif.hamza.moquette.model.Carpet
import alif.hamza.moquette.model.Order
import alif.hamza.moquette.ui.order.adapter.CarpetsAdapter
import kotlinx.android.synthetic.main.fragment_order.*
import java.util.*

class OrderFragment : BaseFragment() {

    private var order: Order? = null

    private lateinit var carpetsAdapter: CarpetsAdapter
    var carpets: ArrayList<Carpet>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        order = if (arguments != null) {
            arguments.getSerializable(ORDER_KEY) as Order
        } else {
            Order()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_order, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun setUp(view: View?) {
        carpetsAdapter = CarpetsAdapter(carpets)
        carpetsRV!!.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        carpetsRV!!.adapter = carpetsAdapter
        addCarpetsL.setOnClickListener {
            addCarpet()
        }
        nextL.setOnClickListener {
            nextStep()
        }
    }

    internal fun addCarpet() {
        val builder = AlertDialog.Builder(context)
        val view = activity.layoutInflater.inflate(R.layout.dialog_add_carpet, null)

        val widthET = view.findViewById<EditText>(R.id.widthET)
        val highET = view.findViewById<EditText>(R.id.highET)

        widthET.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                highET.requestFocus()
                return@OnEditorActionListener true
            }
            false
        })

        builder.setView(view)
        val dialog = builder.create()
        dialog.show()

        highET.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {

                view.findViewById<View>(R.id.addCarpetB).setOnClickListener {
                    val width = widthET.text.toString()
                    val high = highET.text.toString()
                    if ((high != null && !high.isEmpty()) && (width != null && !width.isEmpty())) {
                        addCarpetRV(width, high)
                        dialog.dismiss()
                    }
                }
                return@OnEditorActionListener true
            }
            false
        })

        view.findViewById<View>(R.id.addCarpetB).setOnClickListener {
            val width = widthET.text.toString()
            val high = highET.text.toString()
            if ((high != null && !high.isEmpty()) && (width != null && !width.isEmpty())) {
                addCarpetRV(width, high)
                dialog.dismiss()
            }
        }
    }

    internal fun addCarpetRV(width: String, high: String) {
        val carpet = Carpet(carpets!!.size + 1, width, high)
        carpets!!.add(carpet)
        carpetsAdapter.notifyItemInserted(carpets!!.size - 1)
        carpetsRV!!.scrollToPosition(carpets!!.size - 1)
    }


    internal fun nextStep() {
        if (carpets == null || carpets!!.isEmpty()) {
            val builder = AlertDialog.Builder(context)
            val view = activity.layoutInflater.inflate(R.layout.dialog_error_empty_carpets, null)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
        } else {
            order!!.carpets = carpets
            val transaction = activity.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, OrderTypeFragment.newInstance(order))
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    companion object {

        private val ORDER_KEY = "order"

        fun newInstance(order: Order): OrderFragment {
            val fragment = OrderFragment()
            val args = Bundle()
            args.putSerializable(ORDER_KEY, order)
            fragment.arguments = args
            return fragment
        }
    }
}

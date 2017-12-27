package alif.hamza.moquette.ui.map


import com.example.computec.eltadreb.ui.base.BasePresenter
import alif.hamza.moquette.model.Order
import alif.hamza.moquette.model.Price
import alif.hamza.moquette.service.model.map.MapModel
import alif.hamza.moquette.service.model.map.MapModelImpl

class MapPresenter<V : MapContract.View> : BasePresenter<V>(), MapContract.Presenter<V>, MapModel.OnGetPrices,
        MapModel.OnPostOrder {

    private val mapModel: MapModel = MapModelImpl()

    override fun getPrices() {
        mapModel.getPrices(this)
    }

    override fun makeOrder(order: Order) {
        mapModel.postOrder(order, this)
    }

    override fun onSucess(prices: MutableList<Price>) {
        mvpView!!.getPrices(prices)
    }

    override fun onFail() {

    }
}

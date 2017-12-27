package alif.hamza.moquette.service.model.cart

import alif.hamza.moquette.App
import alif.hamza.moquette.model.OrderCart
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartModelImpl : CartModel {

    override fun getOrders(listener: CartModel.OnGetOrders) {

        App.getService.getOrders().enqueue(object : Callback<MutableList<OrderCart>> {

            override fun onResponse(call: Call<MutableList<OrderCart>>?, response: Response<MutableList<OrderCart>>?) {
                if (response!!.isSuccessful) {
                    listener.onSucess(response.body()!!)
                } else {
                    listener.onFail()
                }
            }
            override fun onFailure(call: Call<MutableList<OrderCart>>?, t: Throwable?) {

            }
        })
    }
}
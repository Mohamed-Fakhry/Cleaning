package alif.hamza.moquette.service.model.map

import com.google.gson.GsonBuilder
import alif.hamza.moquette.App
import alif.hamza.moquette.model.Order
import alif.hamza.moquette.model.Price
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapModelImpl: MapModel {

    override fun postOrder(order: Order, listener: MapModel.OnPostOrder) {

        val gson = GsonBuilder().create()

        App.getService.postOrder(gson.toJsonTree(order)).enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {

            }

        })
    }

    override fun getPrices(listener: MapModel.OnGetPrices) {
        App.getService.getPrices().enqueue(object : Callback<MutableList<Price>> {

            override fun onResponse(call: Call<MutableList<Price>>?, response: Response<MutableList<Price>>) =
                    when {
                        response.isSuccessful -> listener.onSucess(response.body()!!)
                        response.code() == 401 -> listener.onFail()
                        else -> listener.onFail()
                    }

            override fun onFailure(call: Call<MutableList<Price>>?, t: Throwable?) {
            }
        })
    }
}
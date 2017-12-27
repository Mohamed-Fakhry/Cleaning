package alif.hamza.moquette.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Mohamed Fakhry on 29/09/2017.
 */
data class ApiError(private val errorCode: Int,
                    @Expose
                    @SerializedName("status_code")
                    private val statusCode: String?,
                    @Expose
                    @SerializedName("message")
                    val message: String?)
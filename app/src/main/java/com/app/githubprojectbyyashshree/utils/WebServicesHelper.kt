package com.enyotalearning.learninghub.utils

import android.util.Log
import androidx.core.text.HtmlCompat
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.StringRequestListener
import okhttp3.OkHttpClient
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object WebServicesHelper {

    interface ResponseListener {
        fun onSuccess(response: String)
        fun onError(errorMessage: String)
    }

    fun getRequest(url: String, isAuthenticationRequired: Boolean = true, headerMap: HashMap<String, String>? = null, listener: ResponseListener, queryParameter: HashMap<String, String>? = null) {
        val builder = AndroidNetworking.get(url)

        builder.build().getAsString(object : StringRequestListener {
            override fun onResponse(response: String) {
                listener.onSuccess(response)

                Log.e("response=", response)
            }

            override fun onError(anError: ANError?) {
                listener.onError("Error")
                Log.e("error=", anError?.message.toString())
            }
        })
    }




}
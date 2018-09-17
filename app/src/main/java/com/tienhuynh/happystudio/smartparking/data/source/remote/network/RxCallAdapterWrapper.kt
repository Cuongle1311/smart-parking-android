package com.tienhuynh.happystudio.smartparking.data.source.remote.network

import android.util.Log
import okhttp3.ResponseBody
import retrofit2.*
import java.lang.reflect.Type
import javax.net.ssl.HttpsURLConnection

/**
 * This class to handle Error Code
 * Created by TienHuynh3 on 19/05/2018.
 * Copyright © Happy Tech Studio
 */
class RxCallAdapterWrapper<R>(type: Type, retrofit: Retrofit, wrapped: CallAdapter<R, *>?) : BaseRxCallAdapterWrapper<R>(type, retrofit, wrapped) {

    override fun convertRetrofitExceptionToCustomException(throwable: Throwable, retrofit: Retrofit): Throwable {

        if (throwable is HttpException) {
            val converter: Converter<ResponseBody, ApiException> = retrofit.responseBodyConverter(ApiException::class.java, arrayOfNulls<Annotation>(0))
            val response: Response<*>? = throwable.response()
            when (response?.code()) {
                HttpsURLConnection.HTTP_UNAUTHORIZED -> response.errorBody()?.let {
                    val apiException = converter.convert(it)
                    Log.d("XXX", "errrorrrrr: ${apiException.messageError}")
                    apiException.statusCode = HttpsURLConnection.HTTP_UNAUTHORIZED
                    RxBus.publish(UnAuthorizeEvent(apiException))
                    return apiException
                }

                HttpsURLConnection.HTTP_BAD_REQUEST -> response.errorBody()?.let {
                    return converter.convert(it)
                }

                HttpsURLConnection.HTTP_INTERNAL_ERROR -> response.errorBody()?.let {
                    return converter.convert(it)
                }
            }
        }

        return throwable
    }

    override fun createExceptionForSuccessResponse(response: Any?): Throwable? = super.createExceptionForSuccessResponse(response)
}

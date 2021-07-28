package com.haviks.mosof.data.remote

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.haviks.mosof.data.remote.network.ApiResponse
import com.haviks.mosof.data.remote.network.ApiService
import com.haviks.mosof.data.remote.response.PlantResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    fun getPlantConditions(): LiveData<ApiResponse<PlantResponse>> {
        val resultData = MutableLiveData<ApiResponse<PlantResponse>>()

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            ApiService.create()
                .getPlantCondition()
                .enqueue(object : Callback<PlantResponse> {
                    override fun onResponse(
                        call: Call<PlantResponse>,
                        response: Response<PlantResponse>
                    ) {
                        resultData.postValue(
                            response.body()
                                ?.let { ApiResponse.success(it) }
                        )
                    }

                    override fun onFailure(call: Call<PlantResponse>, t: Throwable) {
                        ApiResponse.error(t.message.toString(), mutableListOf(resultData))
                        Log.e("RemoteDataSource", t.message.toString())
                    }

                })
        }, 1500)

        return resultData
    }
}
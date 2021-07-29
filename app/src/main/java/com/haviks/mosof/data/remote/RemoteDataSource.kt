package com.haviks.mosof.data.remote

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.haviks.mosof.data.remote.network.ApiResponse
import com.haviks.mosof.data.remote.network.ApiService
import com.haviks.mosof.data.remote.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    fun getHumidity(): LiveData<ApiResponse<HumidityResponse>> {
        val resultData = MutableLiveData<ApiResponse<HumidityResponse>>()

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            ApiService.create()
                .getHumidity()
                .enqueue(object : Callback<HumidityResponse> {
                    override fun onResponse(
                        call: Call<HumidityResponse>,
                        response: Response<HumidityResponse>
                    ) {
                        resultData.postValue(
                            response.body()
                                ?.let { ApiResponse.success(it) }
                        )
                    }

                    override fun onFailure(call: Call<HumidityResponse>, t: Throwable) {
                        ApiResponse.error(t.message.toString(), mutableListOf(resultData))
                        Log.e("RemoteDataSource", t.message.toString())
                    }

                })
        }, 1500)

        return resultData
    }

    fun getTemperature(): LiveData<ApiResponse<TemperatureResponse>> {
        val resultData = MutableLiveData<ApiResponse<TemperatureResponse>>()

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            ApiService.create()
                .getTemperature()
                .enqueue(object : Callback<TemperatureResponse> {
                    override fun onResponse(
                        call: Call<TemperatureResponse>,
                        response: Response<TemperatureResponse>
                    ) {
                        resultData.postValue(
                            response.body()
                                ?.let { ApiResponse.success(it) }
                        )
                    }

                    override fun onFailure(call: Call<TemperatureResponse>, t: Throwable) {
                        ApiResponse.error(t.message.toString(), mutableListOf(resultData))
                        Log.e("RemoteDataSource", t.message.toString())
                    }

                })
        }, 1500)

        return resultData
    }

    fun getSoilDryness(): LiveData<ApiResponse<SoilDrynessResponse>> {
        val resultData = MutableLiveData<ApiResponse<SoilDrynessResponse>>()

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            ApiService.create()
                .getSoilDryness()
                .enqueue(object : Callback<SoilDrynessResponse> {
                    override fun onResponse(
                        call: Call<SoilDrynessResponse>,
                        response: Response<SoilDrynessResponse>
                    ) {
                        resultData.postValue(
                            response.body()
                                ?.let { ApiResponse.success(it) }
                        )
                    }

                    override fun onFailure(call: Call<SoilDrynessResponse>, t: Throwable) {
                        ApiResponse.error(t.message.toString(), mutableListOf(resultData))
                        Log.e("RemoteDataSource", t.message.toString())
                    }

                })
        }, 1500)

        return resultData
    }

    fun getSoilMoisture(): LiveData<ApiResponse<SoilMoistureResponse>> {
        val resultData = MutableLiveData<ApiResponse<SoilMoistureResponse>>()

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            ApiService.create()
                .getSoilMoisture()
                .enqueue(object : Callback<SoilMoistureResponse> {
                    override fun onResponse(
                        call: Call<SoilMoistureResponse>,
                        response: Response<SoilMoistureResponse>
                    ) {
                        resultData.postValue(
                            response.body()
                                ?.let { ApiResponse.success(it) }
                        )
                    }

                    override fun onFailure(call: Call<SoilMoistureResponse>, t: Throwable) {
                        ApiResponse.error(t.message.toString(), mutableListOf(resultData))
                        Log.e("RemoteDataSource", t.message.toString())
                    }

                })
        }, 1500)

        return resultData
    }
}
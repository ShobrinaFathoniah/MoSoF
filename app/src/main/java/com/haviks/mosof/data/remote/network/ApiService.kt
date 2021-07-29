package com.haviks.mosof.data.remote.network

import com.google.gson.GsonBuilder
import com.haviks.mosof.data.remote.response.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("Accept: application/json")
    @GET("/api/v2/dummmy/feeds/smart-pot.humidity")
    fun getHumidity(): Call<HumidityResponse>

    @Headers("Accept: application/json")
    @GET("/api/v2/dummmy/feeds/smart-pot.temperature")
    fun getTemperature(): Call<TemperatureResponse>

    @Headers("Accept: application/json")
    @GET("/api/v2/dummmy/feeds/smart-pot.soil-percent")
    fun getSoilDryness(): Call<SoilDrynessResponse>

    @Headers("Accept: application/json")
    @GET("/api/v2/dummmy/feeds/smart-pot.soil-moisture")
    fun getSoilMoisture(): Call<SoilMoistureResponse>

    companion object {
        private const val BASE_URL = "https://io.adafruit.com/"

        fun create(): ApiService {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .addInterceptor(loggingInterceptor)
                .build()
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}
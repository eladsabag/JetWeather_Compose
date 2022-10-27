package com.example.jetweather_compose.repository

import com.example.jetweather_compose.data.DataOrException
import com.example.jetweather_compose.model.Weather
import com.example.jetweather_compose.network.WeatherAPI
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherAPI){
    suspend fun getWeather(cityQuery: String, units: String): DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(query = cityQuery, units = units)
        } catch (e: Exception) {
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }
}
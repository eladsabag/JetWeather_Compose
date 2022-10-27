package com.example.jetweather_compose.repository

import com.example.jetweather_compose.data.WeatherDAO
import com.example.jetweather_compose.model.Favorite
import com.example.jetweather_compose.model.Unit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherDBRepository @Inject constructor(private val weatherDAO: WeatherDAO) {
    // Favorite
    fun getFavorites(): Flow<List<Favorite>> = weatherDAO.getFavorites()
    suspend fun insertFavorite(favorite: Favorite) = weatherDAO.insertFavorite(favorite)
    suspend fun updateFavorite(favorite: Favorite) = weatherDAO.updateFavorite(favorite)
    suspend fun  deleteAllFavorites() = weatherDAO.deleteAllFavorites()
    suspend fun deleteFavorite(favorite: Favorite) = weatherDAO.deleteFavorite(favorite)
    suspend fun getFavById(city: String): Favorite = weatherDAO.getFavById(city)

    // Unit
    fun getUnits(): Flow<List<Unit>> = weatherDAO.getUnits()
    suspend fun insertUnit(unit: Unit) = weatherDAO.insertUnit(unit)
    suspend fun updateUnit(unit: Unit) = weatherDAO.updateUnit(unit)
    suspend fun deleteAllUnits() = weatherDAO.deleteAllUnits()
    suspend fun deleteUnit(unit: Unit) = weatherDAO.deleteUnit(unit)
}
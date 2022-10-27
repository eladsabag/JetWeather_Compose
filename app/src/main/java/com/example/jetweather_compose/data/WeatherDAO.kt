package com.example.jetweather_compose.data

import androidx.room.*
import com.example.jetweather_compose.model.Favorite
import com.example.jetweather_compose.model.Unit
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDAO {
    // Favorite
    @Query(value = "SELECT * FROM fav_tbl")
    fun getFavorites(): Flow<List<Favorite>>

    @Query(value = "SELECT * FROM fav_tbl WHERE city =:city")
    suspend fun getFavById(city: String): Favorite

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavorite(favorite: Favorite)

    @Query(value = "DELETE FROM fav_tbl")
    suspend fun deleteAllFavorites()

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)

    // Unit
    @Query(value = "SELECT * FROM settings_tbl")
    fun getUnits(): Flow<List<Unit>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUnit(unit: Unit)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUnit(unit: Unit)

    @Query(value = "DELETE FROM settings_tbl")
    suspend fun deleteAllUnits()

    @Delete
    suspend fun deleteUnit(unit: Unit)
}
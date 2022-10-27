package com.example.jetweather_compose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetweather_compose.model.Favorite
import com.example.jetweather_compose.model.Unit

@Database(entities = [Favorite::class, Unit::class], version = 2, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDAO
}
package com.example.jetweather_compose.di

import android.content.Context
import androidx.room.Room
import com.example.jetweather_compose.data.WeatherDAO
import com.example.jetweather_compose.data.WeatherDatabase
import com.example.jetweather_compose.network.WeatherAPI
import com.example.jetweather_compose.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideOpenWeatherApi(): WeatherAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideWeatherDao(weatherDatabase: WeatherDatabase): WeatherDAO
            = weatherDatabase.weatherDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): WeatherDatabase
            = Room.databaseBuilder(
        context,
        WeatherDatabase::class.java,
        "weather_database"
    )
        .fallbackToDestructiveMigration()
        .build()

}
package br.com.artpeak

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Tatuagem::class), version = 1)
abstract class TatuagenDatabase: RoomDatabase() {
    abstract fun tatuagenDAO() : TatuagenDAO
}
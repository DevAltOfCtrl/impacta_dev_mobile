package br.com.artpeak

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Tatuagem::class, Login::class), version = 4)
abstract class TatuagenDatabase: RoomDatabase() {
    abstract fun tatuagenDAO() : TatuagenDAO
    abstract fun loginDAO() : LoginDAO
}

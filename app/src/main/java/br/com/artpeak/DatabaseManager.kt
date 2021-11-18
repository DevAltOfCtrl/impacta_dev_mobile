package br.com.artpeak

import androidx.room.Room

object DatabaseManager {
    private var dbInstance: TatuagenDatabase

    init {
        val context = ARTPeakApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            TatuagenDatabase::class.java,
            "lms.sqlite"
        ).build()
    }

    fun getTatuagenDAO(): TatuagenDAO {
        return dbInstance.tatuagenDAO()
    }
}
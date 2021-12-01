package br.com.artpeak

import androidx.room.Room

object DatabaseManager {
    private var dbInstance: TatuagenDatabase

    init {
        val context = ARTPeakApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            TatuagenDatabase::class.java,
            "artpeak.sqlite_v3"
        ).build()
    }

    fun getTatuagenDAO(): TatuagenDAO {
        return dbInstance.tatuagenDAO()
    }
    fun getLoginDAO(): LoginDAO {
        return dbInstance.loginDAO()
    }

}
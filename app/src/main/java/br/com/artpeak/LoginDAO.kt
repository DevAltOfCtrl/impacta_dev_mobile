package br.com.artpeak

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoginDAO {
    @Query("SELECT * FROM usuarioS WHERE login = :login")
    fun getByLogin(login: String): Login?

    @Query("SELECT * FROM usuarios")
    fun findAll(): List<Login>

    @Insert
    fun insert(usuarios: Login)

    @Delete
    fun delete(usuarios: Login)
}
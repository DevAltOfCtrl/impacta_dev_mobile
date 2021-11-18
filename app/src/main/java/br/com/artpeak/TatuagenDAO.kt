package br.com.artpeak

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TatuagenDAO {

    @Query("SELECT * FROM tatuagen WHERE nome = :nome")
    fun getByNome(nome: String): Tatuagem?

    @Query("SELECT * FROM tatuagen")
    fun findAll(): List<Tatuagem>

    @Insert
    fun insert(disciplina: Tatuagem)

    @Delete
    fun delete(disciplina: Tatuagem)
}
package br.com.artpeak

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "tatuagen")
class Tatuagem: Serializable {
    @PrimaryKey
    var nome = ""
    var url = ""

//    override fun toString(): String {
//        return "Tatuagen(nome='$nome')"
//    }
//
//    fun toJson(): String {
//        return GsonBuilder().create().toJson(this)
//    }
}
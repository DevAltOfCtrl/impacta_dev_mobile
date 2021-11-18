package br.com.artpeak

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tatuagen")
class Tatuagem: Serializable {
    @PrimaryKey
    var nome = ""
    var url = ""
}
package br.com.artpeak

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "usuarios")
class Login: Serializable {
    @PrimaryKey
    var login = ""
    var nome = ""
    var senha = ""

    //USADO PARA MANIPULAÇÃO DOS DADOS PARA O CADASTRO
    override fun toString(): String {
        return "Login(login='$login')"
    }

    //USADO PARA MANIPULAÇÃO DOS DADOS PARA O CADASTRO
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}
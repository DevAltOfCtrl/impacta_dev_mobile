package br.com.artpeak

import android.content.Context
import android.util.Log
import br.com.artpeak.HttpHelper.client
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.net.URL


object TatuagemService  {

    val host = "https://edsilva.pythonanywhere.com"
    val TAG = "WS_app"

    //RETORNA TODAS AS TATUAGENS
    fun get_tatu(): List<Tatuagem>{
        try {
            var to_remove = Prefs.getStringSet("to_remove") as MutableSet<String>
            for (t in to_remove){
                HttpHelper.delete("$host/delete/${t}")
            }

            var tatuagens = mutableListOf<Tatuagem>()
            val url = "$host/tatuagens"
            val json = HttpHelper.get(url)
            tatuagens = parserJson<MutableList<Tatuagem>>(json)
            //saveBDUsuario(tatuagens)
            for (t in tatuagens) {
                saveTatooOffline(t)
            }
            return tatuagens
        }catch (t: Exception){
            var tatuagens = DatabaseManager.getTatuagenDAO().findAll()
            return tatuagens

        }        }

    //RETOENA TODOS OS USUÁRIOS
    fun get_login(): List<Login>{
        try{
            var usuarios = mutableListOf<Login>()
            val url = "$host/usuarios_cadastrados"
            val json = HttpHelper.get(url)
            Log.d(TAG, json)
            usuarios = parserJson<MutableList<Login>>(json)
            for (u in usuarios) {
                saveUsuarioOffline(u)
            }
            return usuarios
        }catch (t: Exception){
            var usuarios = DatabaseManager.getLoginDAO().findAll()
            return usuarios

        }
    }


    //SALVA UM NOVO USUÁRIO NA API E NO BD
    fun saveBDUsuario(usuario: Login): br.com.artpeak.Response {
        try {
            val json = HttpHelper.post("$host/cadastro", usuario.toJson())
            return parserJson(json)
        } catch (t: Exception){
            saveUsuarioOffline(usuario)
            return Response("OK", "Usuário salvo no dispositivo")
        }

    }

    //VERIFICA SE JA EXISTE UMA TATUAGEN
    fun existeTatuagen(tatuagen: Tatuagem): Boolean {
        val dao = DatabaseManager.getTatuagenDAO()
        return dao.getByNome(tatuagen.nome) != null

    }

    //VERIFICA SE JA EXISTE UM USUÁRIO
    fun existeUsuario(usuario: Login): Boolean {
        val dao = DatabaseManager.getLoginDAO()
        return dao.getByLogin(usuario.login) != null

    }

    //EXCLUI UMA TATUAGEN
    fun delete(tatuagen: Tatuagem){
        try{
            HttpHelper.delete("$host/delete/${tatuagen.nome}")
        }catch (t: Exception){
            var to_remove = Prefs.getStringSet("to_remove") as MutableSet<String>
            to_remove.add(tatuagen.nome!!.toString())
            Prefs.setStringSet("to_remove", to_remove)
        }finally {
            DatabaseManager.getTatuagenDAO().delete(tatuagen)
        }
    }

    //SALVA UMA TATUAGEN NO BD PARA SER ACESSADA OFFLINE
    fun saveTatooOffline(tatuagen: Tatuagem) : Boolean {
        val dao = DatabaseManager.getTatuagenDAO()

        if (! existeTatuagen(tatuagen)) {
            dao.insert(tatuagen)
        }

        return true
    }

    //SALVA UM USUÁRIO NO BD PARA LOGAR OFFLINE
    fun saveUsuarioOffline(usuario: Login) : Boolean {
        val dao = DatabaseManager.getLoginDAO()

        if (! existeUsuario(usuario)) {
            dao.insert(usuario)
        }

        return true
    }


    // Lê resposta em formato JSON
    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}
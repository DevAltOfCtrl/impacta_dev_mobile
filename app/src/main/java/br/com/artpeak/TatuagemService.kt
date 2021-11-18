package br.com.artpeak

import android.content.Context
import android.util.Log
import br.com.artpeak.HttpHelper.client
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.Request
import java.io.IOException


object TatuagemService  {

    val host = "https://edsilva.pythonanywhere.com"
    val TAG = "WS_app"
    fun get(context: Context): List<Tatuagem>{
        try {
            var to_remove = Prefs.getStringSet("to_remove") as MutableSet<String>
            for (t in to_remove){
                HttpHelper.delete("$host/delete/${t}")
            }
            var tatuagens = mutableListOf<Tatuagem>()
            val url = "$host/tatuagens"
            val json = HttpHelper.get(url)
            tatuagens = parserJson<MutableList<Tatuagem>>(json)
            saveBD(tatuagens)
            return tatuagens
        }catch (t: Exception){
            var tatuagens = DatabaseManager.getTatuagenDAO().findAll()
            return tatuagens

        }        }

    fun get_tauagen(tatuagen: Tatuagem) {
        try{
            HttpHelper.get("$host/tatuagen/${tatuagen.nome}")
        }catch (t: Exception){
            var to_remove = Prefs.getStringSet("to_remove") as MutableSet<String>
            to_remove.add(tatuagen.url!!.toString())
            Prefs.setStringSet("to_remove", to_remove)
        }finally {
            DatabaseManager.getTatuagenDAO().delete(tatuagen)
        }
    }

    private fun saveBD(tatuagen: List<Tatuagem>){
        for (t in tatuagen){
            val filtro = DatabaseManager.getTatuagenDAO().getByNome(t.nome!!)
            if (filtro == null){
                DatabaseManager.getTatuagenDAO().insert(t)
            }
        }
    }


    fun saveTatuagen(tatuagen: Tatuagem){
        val url = "$host/tatuagens"
        var json = HttpHelper.post(url, GsonBuilder().create().toJson(tatuagen))

    }

    fun existeTatuagen(tatuagen: Tatuagem): Boolean {
        val dao = DatabaseManager.getTatuagenDAO()
        return dao.getByNome(tatuagen.nome) != null

    }

    // DELETE

    fun delete(tatuagen: Tatuagem){
        try{
            HttpHelper.delete("$host/delete/${tatuagen.nome}")
        }catch (t: Exception){
            var to_remove = Prefs.getStringSet("to_remove") as MutableSet<String>
            to_remove.add(tatuagen.url!!.toString())
            Prefs.setStringSet("to_remove", to_remove)
        }finally {
            DatabaseManager.getTatuagenDAO().delete(tatuagen)
        }
    }

    fun saveOffline(tatuagen: Tatuagem) : Boolean {
        val dao = DatabaseManager.getTatuagenDAO()

        if (! existeTatuagen(tatuagen)) {
            dao.insert(tatuagen)
        }

        return true

    }
    // Lê resposta em formato JSON
    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}
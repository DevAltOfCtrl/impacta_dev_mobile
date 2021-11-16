package br.com.artpeak

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object TatuagemService  {

    val host = "https://edsilva.pythonanywhere.com"
    val TAG = "WS_app"
    fun getTatuagem(context: Context): List<Tatuagem> {
        var tatuagens = mutableListOf<Tatuagem>()
        val url = "$host/tatuagens"
        val json = HttpHelper.get(url)
        Log.d(TAG, json)

        tatuagens = parseJson<MutableList<Tatuagem>>(json)

        return  tatuagens
    }

    fun getUsuarios(): List<Login> {
        var usuarios = mutableListOf<Login>()
        val url = "$host/login"
        val json = HttpHelper.get_usuario(url)
        Log.d(TAG, json)

        usuarios = parseJson<MutableList<Login>>(json)

        return  usuarios
    }
    inline fun <reified T> parseJson(json: String): T{
        val type = object : TypeToken<T>(){}.type
        return  Gson().fromJson<T>(json, type)
    }
}
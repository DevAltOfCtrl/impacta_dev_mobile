package br.com.artpeak

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request

object HttpHelper {
    var client = OkHttpClient()
    val JSON = MediaType.parse("application/json; charset=utf-8")

    fun get(url: String): String {
        val request = Request.Builder().url(url).get().build()
        return getJson(request)
    }
    fun get_usuario(url: String): String {
        val request = Request.Builder().url(url).get().build()
        return getJson(request)
    }

    fun delete(url: String): String {
        val request = Request.Builder().url(url).delete().build()
        return getJson(request)
    }

    private fun getJson(request: Request): String {
        val response = client.newCall(request).execute()
        val body = response.body()
        val json = body?.string()
        return json!!
    }
}
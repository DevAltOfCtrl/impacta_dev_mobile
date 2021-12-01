package br.com.artpeak

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d("ArtPeakFirebase", "Novo token: $token")
        Prefs.setString("FB_TOKEN", token!!)
    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage?) {
        Log.d("ArtPeakFirebase", "onMessageReceived")

        if (mensagemRemota?.notification != null) {
            val titulo = mensagemRemota?.notification?.title
            var corpo = mensagemRemota?.notification?.body
            Log.d("ArtPeakFirebase", "Titulo: ${titulo}")
            Log.d("ArtPeakFirebase", "Corpo: ${corpo}")

            if (mensagemRemota?.data.isNotEmpty()) {
                val disciplinaId = mensagemRemota.data.get("disciplinaId")
                corpo += " $disciplinaId"
            }


            val intent = Intent(this, TatuagenActivity::class.java)

            NotificationUtil.create(1, intent, titulo!!, corpo!!)
        }

    }
}
package br.com.artpeak

import android.app.Application
import java.lang.IllegalStateException

class ARTPeakApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object{
        private var appInstance: ARTPeakApplication? = null

        fun getInstance(): ARTPeakApplication{
            if(appInstance == null){
                throw IllegalStateException("Configuração com problema no Manifest")
            }
            return appInstance!!
        }
    }
    // chamado quando android terminar processo da aplicação
    override fun onTerminate() {
        super.onTerminate()
    }

}
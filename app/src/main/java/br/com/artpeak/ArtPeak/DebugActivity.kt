package br.com.artpeak.ArtPeak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class DebugActivity : AppCompatActivity() {

    private val className: String
        get() {
            //br.com.fernandosousa.lmsapp.DebugActivity
            val s = javaClass.name
            //.DebugActivity
            return s.substring(s.lastIndexOf("."))
        }
    private val TAG = "ArtPeak"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "${className}.onCreate chamado")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "${className}.onStart chamado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "${className}.onRestart chamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "${className}.onResume chamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "${className}.onPause chamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "${className}.onStop chamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "${className}.onDestroy chamado")
    }
}
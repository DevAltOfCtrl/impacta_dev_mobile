package br.com.artpeak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tatuagen.*
import kotlinx.android.synthetic.main.toolbar.*

class TatuagenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tatuagen)
        supportActionBar?.title = "Detalhes da tatuagem"
        supportActionBar?.setDisplayHomeAsUpEnabled(
            true
        )
        val tatuagen = intent.getSerializableExtra("tatuagen") as Tatuagem
        tatuagen_estilo.text = tatuagen.nome

        //Toast.makeText(this, "${tatuagen.estilo}", Toast.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
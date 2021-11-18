package br.com.artpeak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.activity_tatuagen.*

class TatuagenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tatuagen)
        supportActionBar?.title = "Informações sobre a tatuagen"
        supportActionBar?.setDisplayHomeAsUpEnabled(
            true
        )

        val tatuagen = intent.getSerializableExtra("tatuagen") as Tatuagem
        tatuagen_estilo.text = tatuagen.nome


        botao_delete.setOnClickListener {
            Thread{
                TatuagemService.delete(tatuagen)
                runOnUiThread {
                    finish()
                }
            }.start()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
package br.com.artpeak

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.activity_tatuagen.*
import kotlinx.android.synthetic.main.toolbar.*

class TatuagenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tatuagen)

        supportActionBar?.title = "Informações sobre a tatuagem"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tatuagem = intent.getSerializableExtra("tatuagem") as Tatuagem
        tatuagen_estilo.text = tatuagem?.nome


        botao_delete.setOnClickListener {
            Thread{
                //CHAMANDO A TREAD PARA EXCLUIR A TATUAGEN
                TatuagemService.delete(tatuagem)
                TatuagemService.get_tatu()
                //TatuagemService.get_tatu()
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
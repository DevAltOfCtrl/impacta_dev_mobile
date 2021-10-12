package br.com.artpeak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.toolbar.*

class ConfigActivity : NavigationDrawerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        configuraMenuLateral2()
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Configurações"
        supportActionBar?.setDisplayHomeAsUpEnabled(
            true
        )
    }
    val contexto = this
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main2, menu)
        /// IMPLEMENTAÇÃO PARA O BOTÃO BUSCAR
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView).setOnQueryTextListener (
            object: SearchView.OnQueryTextListener {
                override fun onQueryTextChange(texto: String) : Boolean {
                    Toast.makeText(contexto, "Busca: ${texto}", Toast.LENGTH_LONG).show()
                    return false
                }

                override fun onQueryTextSubmit(texto: String): Boolean {
                    Toast.makeText(contexto, "Busca: ${texto}", Toast.LENGTH_LONG).show()
                    return false
                }
            }
        )
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
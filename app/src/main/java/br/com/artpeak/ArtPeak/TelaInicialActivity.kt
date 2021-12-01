package br.com.artpeak.ArtPeak
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras
//        val nome_pessoa = args?.getString("nome_pessoa")
//        val numero = args?.getInt("numero")
//        Toast.makeText(this, "Parâmetro 1: $nome_pessoa", Toast.LENGTH_LONG).show()
//        Toast.makeText(this, "Parâmetro 2: $numero", Toast.LENGTH_LONG).show()
        val nome_usuario = args?.getString("nome_usuario")

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        val id = item.itemId

        if (id == R.id.action_buscar) {
            // IMPLEMENTAR A LÓGICA NECESSÁRIA PARA TRATAMANTO DE EVENTO DO ITEM DE MENU
            Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Atualizar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
        } else if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)

    }

}
package br.com.artpeak

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.toolbar.*

class HomePageActivity : NavigationDrawerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)


        setSupportActionBar(toolbar)

        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()

        recyclerTatuagens?.layoutManager = LinearLayoutManager(this)
        recyclerTatuagens?.itemAnimator = DefaultItemAnimator()
        recyclerTatuagens?.setHasFixedSize(true)
    }

    fun onClickTatuagem(tatuagem: Tatuagem) {
        Toast.makeText(this, "Tatuagem ${tatuagem.nome}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, TatuagenActivity::class.java)
        intent.putExtra("tatuagen", tatuagem)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        taskTatuagem()

    }

    var tatuagens = listOf<Tatuagem>()

    fun taskTatuagem() {
        Thread {
            tatuagens = TatuagemService.get(context)
            runOnUiThread {
                recyclerTatuagens?.adapter = TatuagemAdapter(tatuagens) { onClickTatuagem(it) }
            }
        }.start()
    }

    val context = this

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView). setOnQueryTextListener(
            object: SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }

                override fun onQueryTextSubmit(query: String?): Boolean {
                    Toast.makeText(context, "Buscar ${query}", Toast.LENGTH_LONG).show()
                    return false
                }
            }
        )

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id == R.id.action_buscar){
            Toast.makeText(this, "Pesquisar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_atualizar){
            Toast.makeText(this, "Atualizar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_config){
            val intent = Intent(this, ConfigActivity::class.java)
            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        } else if (id == R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)
    }



}
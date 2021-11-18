package br.com.artpeak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.toolbar.*

open class NavigationDrawerActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun configuraMenuLateral(){
        var toogle = ActionBarDrawerToggle(
            this,
            LayoutMenuLateral,
            toolbar,
            R.string.abrir,
            R.string.fechar
        )

        LayoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        nav_menu_lateral.setNavigationItemSelectedListener(this)


    }
    protected fun configuraMenuLateral2(){
        var toogle = ActionBarDrawerToggle(
            this,
            LayoutMenuLateral,
            toolbar,
            R.string.abrir,
            R.string.fechar
        )

        nav_menu_lateral.setNavigationItemSelectedListener(this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){

            R.id.nav_home -> {
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomePageActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_mensagem -> {
                Toast.makeText(this, "Mensagens", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,  MensagensActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_favorito -> {
                Toast.makeText(this, "Favoritos", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, FavoritosActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_config -> {
                Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ConfigActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_sair -> {
                Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
                finishAffinity()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

        LayoutMenuLateral.closeDrawer(GravityCompat.START)
        return true

    }
}
package br.com.artpeak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.toolbar.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        supportActionBar?.title = "Cadastro de Usuarios"
        supportActionBar?.setDisplayHomeAsUpEnabled(
            true
        )

        usuario_cadastro.setTextColor(getResources().getColor(R.color.dark_grey))
        usuario_cadastro.setHintTextColor(getResources().getColor(R.color.grey))
        senha_cadastro.setTextColor(getResources().getColor(R.color.dark_grey))
        senha_cadastro.setHintTextColor(getResources().getColor(R.color.grey))
        nome_cadastro.setTextColor(getResources().getColor(R.color.dark_grey))
        nome_cadastro.setHintTextColor(getResources().getColor(R.color.grey))


        usuario_cadastro.setText("")
        senha_cadastro.setText("")

        cadastro_button.setOnClickListener {
            val usuario_cad = Login()
            usuario_cad.login = usuario_cadastro.text.toString()
            usuario_cad.nome = nome_cadastro.text.toString()
            usuario_cad.senha = senha_cadastro.text.toString()


            val intent = Intent(this, LoginActivity::class.java)
            val usuario = usuario_cadastro.text.toString()
            val senha = senha_cadastro.text.toString()
            intent.putExtra("nome", usuario)
            intent.putExtra("nome_usuario", usuario)
            intent.putExtra("senha_usuario", senha)

            if (usuario == "" || senha == ""){
                Toast.makeText(this, "Informe um usuario e senha", Toast.LENGTH_LONG).show()
            }else{
                taskAtualizar(usuario_cad)
                val args = intent.extras
                val usuario_name = args?.getString("nome")
                Toast.makeText(this, "$usuario_name Cadastro com sucesso", Toast.LENGTH_SHORT).show()

                startActivity(intent)
            }
        }

    }

    private fun taskAtualizar(usuario: Login) {
        // Thread para salvar o usuario
        Thread {
            TatuagemService.saveBDUsuario(usuario)
        }.start()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}


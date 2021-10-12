package br.com.artpeak

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.widget.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usuario.setTextColor(getResources().getColor(R.color.dark_grey))
        usuario.setHintTextColor(getResources().getColor(R.color.grey))
        senha.setTextColor(getResources().getColor(R.color.dark_grey))
        senha.setHintTextColor(getResources().getColor(R.color.grey))

        login_button.setOnClickListener {
            val user = usuario.text.toString()
            val password = senha.text.toString()
            val intent = Intent(this, HomePageActivity::class.java)
            intent.putExtra("user_name", user)

            intent.putExtra("nome_usuario", user)
            intent.putExtra("senha_usuario", password)
            if (user == "aluno" && password == "impacta"){

                val args = intent.extras
                val user_name = args?.getString("user_name")
                Toast.makeText(this, "Olá $user_name", Toast.LENGTH_LONG).show()

                startActivity(intent)
            }else{

                makeText(this, "Usuário ou senha incorreto", Toast.LENGTH_LONG).show()
            }
        }

        sigin.setOnClickListener {
            Toast.makeText(this, "Em desenvolvimento :)", Toast.LENGTH_SHORT).show()
        }

    }

}
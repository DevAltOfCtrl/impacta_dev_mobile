package br.com.artpeak.ArtPeak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        tattoo_login.setImageResource(R.drawable.tattoo_login)
        ic_user_login.setImageResource(R.drawable.user)
        ic_key_login.setImageResource(R.drawable.key)

        botao_login.setOnClickListener {
            val nome_usuario = campo_usuario.text.toString()
            val senha_usuario = campo_senha.text.toString()

            var intent = Intent(this, TelaInicialActivity::class.java)

            intent.putExtra("nome_usuario", nome_usuario)
            intent.putExtra("senha_usuario", senha_usuario)

            if (nome_usuario == "aluno" && senha_usuario == "impacta") {
                Toast.makeText(this,"Home", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }
            else {
                Toast.makeText(this,"Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
            }
        }

        botao_cadastrar.setOnClickListener {
                Toast.makeText(this,"Em desenvolvimento", Toast.LENGTH_LONG).show()
        }
    }
}
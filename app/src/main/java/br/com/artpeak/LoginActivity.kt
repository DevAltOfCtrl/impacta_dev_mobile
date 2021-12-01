package br.com.artpeak

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.makeText
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : DebugActivity() {
    //INSTANCIANDO UMA LISTA DE USUARIOS
    var usuarios = arrayListOf<Login>()
    override fun onCreate(savedInstanceState: Bundle?) {
        val TAG = "WS_app"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usuario.setTextColor(getResources().getColor(R.color.dark_grey))
        usuario.setHintTextColor(getResources().getColor(R.color.grey))
        senha.setTextColor(getResources().getColor(R.color.dark_grey))
        senha.setHintTextColor(getResources().getColor(R.color.grey))

        usuario.setText(Prefs.getString("user"))
        senha.setText(Prefs.getString("password"))
        checklogin.isChecked = Prefs.getBoolean("remember_login")


    login_button.setOnClickListener {
        Thread{
            //TRANSFORMANDO A LISTA DE USUÁRIOS EM UMA ARRYLIST COM O RESULTADO DO GET_LOGIN
            usuarios = TatuagemService.get_login() as ArrayList<Login>
            runOnUiThread {
                val user = usuario.text.toString()
                val password = senha.text.toString()
                val check_login =  checklogin.isChecked

                if(check_login){
                    Prefs.setString("user", user)
                    Prefs.setString("password", password)
                }else{
                    Prefs.setString("user", "")
                    Prefs.setString("password","")
                }
                Prefs.setBoolean("remember_login", check_login)

                val intent = Intent(this, HomePageActivity::class.java)
                intent.putExtra("user_name", user)

                intent.putExtra("nome_usuario", user)
                intent.putExtra("senha_usuario", password)

                for(u in usuarios){
                    if ( user == u.login && password == u.senha){
                        Toast.makeText(this, "Olá ${u.login}", Toast.LENGTH_LONG).show()
                        startActivity(intent)
                        break
                    }else{
                        makeText(this, "Usuário ou senha incorreto", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }.start()

    }

        sigin.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            Toast.makeText(this, "Cadastro", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}
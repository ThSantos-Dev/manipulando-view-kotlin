package com.example.manipulandoview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.manipulandoview.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Passo 2 - variável para receber a activity
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Passo 3 - atribuir a activity a variaável criada binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val toastButton = findViewById<Button>(R.id.toast)
        toastButton.setOnClickListener { mensagemToast() }

/*        val alertButton = findViewById<Button>(R.id.alert)
        alertButton.setOnClickListener { mensagemAlert() }*/

        /*MODO INCORRETO DE SE FAZER*/
        alert.setOnClickListener { mensagemAlert() }


        /*MANEIRA POLITICAMENTE CORRETA*/
        // Passo 4 - utilizar a referencia para a activity por meio do binding
        binding.snack.setOnClickListener { mensagemSnack() }

    }

    private fun mensagemSnack() {
        val snackButton = findViewById<Button>(R.id.snack)
        Snackbar
            .make(snackButton, "Mensagem usando o SNACKBAR", Snackbar.LENGTH_INDEFINITE)
            .setAction("SAIR") { finish() }
            .show()

    }

    private fun mensagemAlert() {
        AlertDialog
            .Builder(this)
            .setTitle("Atenção!!")
            .setMessage("Mensagem usando o ALERT\nDeseja sair do APP?")
            .setPositiveButton("SIM") { _,_ -> finish()}
            .setNegativeButton("NÂO") { _,_ -> }
            .show()

    }

    private fun mensagemToast() {
        Toast
            .makeText(this, "Exemplo de mensagem TOAST...", Toast.LENGTH_SHORT)
            .show()
    }
}
package br.edu.utfpr.hotelpet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.edu.utfpr.hotelpet.databinding.ActivityMainBinding

//Hello girl Daniele
//hi hiiiiiiiiiiiiiiiiiiiii 
class MainActivity : AppCompatActivity() {
//
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        setContentView(binding.root)
        configBotaoServico()
        configBotaoFicha()
        configBotaoCheckIn()
        configBotaoCheckOut()
        configBotaoCadAnimal()
        configBotaoCadTutor()
        Log.i("MainActivity","OnCreate: Estado criado")
    }


    fun configBotaoServico(){
        val botaoServico = binding.imServicos
        botaoServico.setOnClickListener {
            val intent = Intent(this, CadServico::class.java)
            startActivity(intent)
        }
    }

    fun configBotaoFicha(){
        val botaoFicha = binding.imFicha
        botaoFicha.setOnClickListener {
            val intent = Intent(this, FichaComportamentoPet::class.java)
            startActivity(intent)
        }
    }

    fun configBotaoCheckIn(){
        val botaoCheckIn = binding.imCheckin
        botaoCheckIn.setOnClickListener {
            val intent = Intent(this, CheckIn::class.java)
            startActivity(intent)
        }
    }

    fun configBotaoCheckOut(){
        val botaoCheckOut = binding.imCheckout
        botaoCheckOut.setOnClickListener {
            val intent = Intent(this, CheckOut::class.java)
            startActivity(intent)
        }
    }

    fun configBotaoCadAnimal(){
        val botaoCadAnimal = binding.imAnimal
        botaoCadAnimal.setOnClickListener {
            val intent = Intent(this, CadAnimal::class.java)
            startActivity(intent)
        }
    }

    fun configBotaoCadTutor(){
        val botaoCadTutor = binding.imTutor
        botaoCadTutor.setOnClickListener {
            val intent = Intent(this, CadTutor::class.java)
            startActivity(intent)
        }
    }
}
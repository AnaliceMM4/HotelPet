package br.edu.utfpr.hotelpet

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.hotelpet.databinding.ActivityCadtutorBinding

class CadTutor : AppCompatActivity() {

    private val binding by lazy{
        ActivityCadtutorBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)
        configCadCoTutor()
        Log.i("CadTutor","OnCreate: Estado criado")
    }

    fun configCadCoTutor(){
        val botaoCadCoTutor = binding.btRegistrarCoTutor
        botaoCadCoTutor.setOnClickListener {
            val intent = Intent(this, CadCoTutor::class.java)
            startActivity(intent)
        }
    }
}
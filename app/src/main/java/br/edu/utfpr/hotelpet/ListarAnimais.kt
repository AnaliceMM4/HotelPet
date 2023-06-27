package br.edu.utfpr.hotelpet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import br.edu.utfpr.hotelpet.databinding.ActivityCadtutorBinding
import br.edu.utfpr.hotelpet.databinding.ActivityListaranimaisBinding

class ListarAnimais : AppCompatActivity() {

    private val binding by lazy{
        ActivityListaranimaisBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)
    }


    private fun configRecyclerView() {
        val rview = binding.rview
        rview.adapter = adapter
        adapter.click = { animal ->
            val intent = Intent(
                this, CadAnimal::class.java
            ).apply {
                putExtra(CHAVE_ANIMAL, animal.id)
            }
            startActivity(intent)
        }
    }
}
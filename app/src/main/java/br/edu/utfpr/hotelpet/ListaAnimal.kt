package br.edu.utfpr.hotelpet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.hotelpet.adapter.AnimalAdapter
import br.edu.utfpr.hotelpet.dataBase.DataBase
import br.edu.utfpr.hotelpet.databinding.ActivityAnimaisBinding
import br.edu.utfpr.hotelpet.details.DetailAnimal

//import br.edu.utfpr.hotelpet.databinding.ActivityDetailAnimalBinding

class ListaAnimal : AppCompatActivity() {
    private val adapter = AnimalAdapter(context = this)
    private val binding by lazy {
    //chamar a activity_animais
        ActivityAnimaisBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configRecyclerView()
        configFloatingActionButton()
    }

    override fun onResume() {
        super.onResume()
        val db = DataBase.instancia(this)
        val animalDao = db.animalDao()
        adapter.refreshAll(animalDao.findAll())
    }

    private fun configFloatingActionButton() {
        val fab = binding.fab
        fab.setOnClickListener {
            val intent = Intent(this, CadAnimal::class.java)
            startActivity(intent)
        }
    }

    private fun configRecyclerView() {
        val rview = binding.rview
        rview.adapter = adapter
        adapter.click = { animal ->
            val intent = Intent(
                this, DetailAnimal::class.java
            ).apply {
                putExtra(CHAVE_ANIMAL, animal.id)
            }
            startActivity(intent)
        }
    }
}
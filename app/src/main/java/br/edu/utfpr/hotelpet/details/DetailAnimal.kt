package br.edu.utfpr.hotelpet.details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import br.edu.utfpr.hotelpet.CHAVE_ANIMAL
import br.edu.utfpr.hotelpet.CadAnimal
import br.edu.utfpr.hotelpet.R
import br.edu.utfpr.hotelpet.dataBase.DataBase
import br.edu.utfpr.hotelpet.databinding.ActivityDetailAnimalBinding
import br.edu.utfpr.hotelpet.model.Animal

class DetailAnimal : AppCompatActivity() {

    private var animalId: Long = 0L
    private var animal: Animal? = null

    private val binding by lazy {
        ActivityDetailAnimalBinding.inflate(layoutInflater)
    }

    private val animalDao by lazy{
        val db = DataBase.instancia(this)
        db.animalDao()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val db = DataBase.instancia(this)
        val animalDao = db.animalDao()
        when (item.itemId) {
            R.id.menu_delete -> {
                Log.i("DetailAnimal", "OnOptionsItemSelected: remover")
                animal?.let { animalDao.delete(it) }
                finish()
            }

            R.id.menu_editar -> {
                Log.i("DetailAnimal", "OnOptionsItemSelected: editar")
                Intent(this, CadAnimal::class.java).apply {
                    putExtra(CHAVE_ANIMAL, animalId)
                    startActivity(this)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        animalId = intent.getLongExtra(CHAVE_ANIMAL, 0L)
    }

    override fun onResume() {
        super.onResume()
        animal = animalDao.findById(animalId)
        animal?.let {
            preencheCampos(it)
        } ?: finish()
    }

    private fun preencheCampos(animal: Animal) {
        with(binding) {
            detailNome.text = animal.nome
            detailEspecie.text = animal.especie
            detailPorte.text = animal.porte
            detailAndarHospedagem.text = animal.andarHopedagem
            detailServico.text = animal.servico
        }
    }

}
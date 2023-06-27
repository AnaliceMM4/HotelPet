package br.edu.utfpr.hotelpet.details

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.hotelpet.CHAVE_TUTOR
import br.edu.utfpr.hotelpet.CadTutor
import br.edu.utfpr.hotelpet.R
import br.edu.utfpr.hotelpet.dataBase.DataBase
import br.edu.utfpr.hotelpet.databinding.ActivityDetailTutorBinding
import br.edu.utfpr.hotelpet.model.Tutor

class DetailTutor : AppCompatActivity(){
    private var tutorId: Long = 0L
    private var tutor: Tutor? = null

    private val binding by lazy {
        ActivityDetailTutorBinding.inflate(layoutInflater)
    }

    private val tutorDao by lazy {
        val db = DataBase.instancia(this)
        db.tutorDao()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val db = DataBase.instancia(this)
        val tutorDao = db.tutorDao()
        when (item.itemId) {
            R.id.menu_delete -> {
                Log.i("DetailTutor", "OnOptionsItemSelected: remover")
                tutor?.let { tutorDao.delete(it) }
                finish()
            }

            R.id.menu_editar -> {
                Log.i("DetailTutor", "OnOptionsItemSelected: editar")
                Intent(this, CadTutor::class.java).apply {
                    putExtra(CHAVE_TUTOR, tutorId)
                    startActivity(this)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        tutorId = intent.getLongExtra(CHAVE_TUTOR, 0L)
    }

    override fun onResume() {
        super.onResume()
        tutor = tutorDao.findById(tutorId)
        tutor?.let {
            preencheCampos(it)
        } ?: finish()
    }

    private fun preencheCampos(tutor: Tutor) {
        with(binding) {
            detailNome.text = tutor.nome
            detailTelefone.text = tutor.telefone
            detailCpf.text = tutor.cpf
            detailEndereco.text = tutor.endereco
            detailAnimal.text = tutor.animal
        }
    }
}
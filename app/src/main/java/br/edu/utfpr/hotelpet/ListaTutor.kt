package br.edu.utfpr.hotelpet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.hotelpet.adapter.TutorAdapter
import br.edu.utfpr.hotelpet.dataBase.DataBase
import br.edu.utfpr.hotelpet.databinding.ActivityDetailTutorBinding
import br.edu.utfpr.hotelpet.databinding.ActivityListaTutorBinding
import br.edu.utfpr.hotelpet.databinding.ActivityTutoresBinding

class ListaTutor : AppCompatActivity() {
    private val adapter = TutorAdapter(context = this)
    private val binding by lazy {
        //chama a activity_tutores
        ActivityTutoresBinding.inflate(layoutInflater)
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
        val tutorDao = db.tutorDao()
        adapter.refreshAll(tutorDao.findAll())
    }

    private fun configFloatingActionButton() {
        val fab = binding.fab
        fab.setOnClickListener {
            val intent = Intent(this, CadTutor::class.java)
            startActivity(intent)
        }
    }

    private fun configRecyclerView() {
        val rview = binding.rview
        rview.adapter = adapter
        adapter.click = { tutor ->
            val intent = Intent(
                this, ActivityDetailTutorBinding::class.java
            ).apply {
                putExtra(CHAVE_TUTOR, tutor.id)
            }
            startActivity(intent)
        }
    }
}
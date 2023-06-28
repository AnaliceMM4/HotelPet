package br.edu.utfpr.hotelpet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.hotelpet.adapter.FichaComportamentoAdapter
import br.edu.utfpr.hotelpet.dataBase.DataBase
import br.edu.utfpr.hotelpet.databinding.ActivityDetailFichaComportamentoPetBinding
import br.edu.utfpr.hotelpet.databinding.ActivityFichasBinding

class ListaFichaComportamento : AppCompatActivity()  {
    private val adapter = FichaComportamentoAdapter(context = this)
    private val binding by lazy {
        //chama a activity_fichas
        ActivityFichasBinding.inflate(layoutInflater)
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
        val fichaComportamentoDao = db.fichaComportamentoDao()
        adapter.refreshAll(fichaComportamentoDao.findAll())
    }

    private fun configFloatingActionButton() {
        val fab = binding.fab
        fab.setOnClickListener {
            val intent = Intent(this, FichaComportamentoPet::class.java)
            startActivity(intent)
        }
    }

    private fun configRecyclerView() {
        val rview = binding.rview
        rview.adapter = adapter
        adapter.click = { ficha ->
            val intent = Intent(
                this, FichaComportamentoPet::class.java
            ).apply {
                putExtra(CHAVE_FICHACOMPORTAMENTO, ficha.id)
            }
            startActivity(intent)
        }
    }
}
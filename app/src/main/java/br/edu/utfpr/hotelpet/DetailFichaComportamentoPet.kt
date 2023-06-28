package br.edu.utfpr.hotelpet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import br.edu.utfpr.hotelpet.dataBase.DataBase
import br.edu.utfpr.hotelpet.databinding.ActivityDetailFichaComportamentoPetBinding
import br.edu.utfpr.hotelpet.model.FichaComportamento

class DetailFichaComportamentoPet : AppCompatActivity(){
    private var fichaId: Long = 0L
    private var ficha: FichaComportamento? = null

    private val binding by lazy {
        ActivityDetailFichaComportamentoPetBinding.inflate(layoutInflater)
    }

    private val fichaComportamentoDao by lazy {
        val db = DataBase.instancia(this)
        db.fichaComportamentoDao()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val db = DataBase.instancia(this)
        val fichaComportamentoDao = db.fichaComportamentoDao()
        when (item.itemId) {
            R.id.menu_delete -> {
                Log.i("DetailFichaComportamentoPet", "OnOptionsItemSelected: remover")
                ficha?.let { fichaComportamentoDao.delete(it) }
                finish()
            }

            R.id.menu_editar -> {
                Log.i("DetailFichaComportamentoPet", "OnOptionsItemSelected: editar")
                Intent(this, FichaComportamento::class.java).apply {
                    putExtra(CHAVE_FICHACOMPORTAMENTO, fichaId)
                    startActivity(this)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fichaId = intent.getLongExtra(CHAVE_FICHACOMPORTAMENTO, 0L)
    }

    override fun onResume() {
        super.onResume()
        ficha = fichaComportamentoDao.findById(fichaId)
        ficha?.let {
            preencheCampos(it)
        } ?: finish()
    }

    private fun preencheCampos(fichaComportamento: FichaComportamento) {
        with(binding) {
            detailLocalAnimal.text = fichaComportamento.hospedadoEm
            detailSeAlimentaDe.text = fichaComportamento.seAlimentaDe
            detailComportamento.text = fichaComportamento.comportamento
            detailAtividadesRealizadas.text = fichaComportamento.atividades
            detailSaude.text = fichaComportamento.saudeDoAnimal
        }
    }
}
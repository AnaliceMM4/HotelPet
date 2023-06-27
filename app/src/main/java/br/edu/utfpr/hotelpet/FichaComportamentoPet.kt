package br.edu.utfpr.hotelpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.edu.utfpr.hotelpet.dao.FichaComportamentoDao
import br.edu.utfpr.hotelpet.dataBase.DataBase
import br.edu.utfpr.hotelpet.databinding.ActivityFichacomportamentopetBinding
import br.edu.utfpr.hotelpet.model.FichaComportamento

class FichaComportamentoPet : AppCompatActivity() {
<<<<<<< HEAD


=======
    private val binding by lazy{
        ActivityFichacomportamentopetBinding.inflate(layoutInflater)
    }

    private val fichaComportamentoDao: FichaComportamentoDao by lazy{
        val db = DataBase.instancia(this)
        db.fichaComportamentoDao()
    }

    private var idFichaComportamento = 0L
>>>>>>> 7b2eec34fdb87fb91e4a0fdbda3deeb46d7e8f2a

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val botaoFichaComp = binding.btSalvarFicha

        botaoFichaComp.setOnClickListener {
            val campoHospedadoEm = binding.etLocalAnimal
            val hospodadoEm = campoHospedadoEm.text.toString()

            val campoSeAlimentaDe = binding.etAlimentacaoAnimal
            val seAlimentaDe = campoSeAlimentaDe.text.toString()

            val campoComportamento = binding.etComportamentoAnimal
            val comportamento = campoComportamento.text.toString()

            val campoAtividades = binding.etAtividadeRealizadasAnimal
            val atividades = campoAtividades.text.toString()

            val campoSaudeDoAnimal = binding.etSaudeAnimal
            val saudeDoAnimal = campoSaudeDoAnimal.text.toString()

            val fichaComportamento = FichaComportamento(
                id = idFichaComportamento,
                hospedadoEm = hospodadoEm,
                seAlimentaDe = seAlimentaDe,
                comportamento = comportamento,
                atividades = atividades,
                saudeDoAnimal = saudeDoAnimal
            )
            Log.i("Ficha_Comportamento_Pet", "OnCreate: $fichaComportamento")

            val db = DataBase.instancia(this)
            val fichaComportamentoDao = db.fichaComportamentoDao()

            if(idFichaComportamento > 0){
                fichaComportamentoDao.update(fichaComportamento)
            } else {
                fichaComportamentoDao.save(fichaComportamento)
            }

            //fichaComportamentoDao.save(fichaComportamento)
            finish()
        }

        idFichaComportamento = intent.getLongExtra(CHAVE_FICHACOMPORTAMENTO, 0L)
    }

    override fun onResume() {
        super.onResume()
        fichaComportamentoDao.findById(idFichaComportamento)?.let {
            preencheCampos(it)
        }
    }

    private fun preencheCampos(it: FichaComportamento) {
        title = "Editar Ficha Comportamento"
        binding.etLocalAnimal.setText(it.hospedadoEm)
        binding.etAlimentacaoAnimal.setText(it.seAlimentaDe)
        binding.etComportamentoAnimal.setText(it.comportamento)
        binding.etAtividadeRealizadasAnimal.setText(it.atividades)
        binding.etSaudeAnimal.setText(it.saudeDoAnimal)
    }
}
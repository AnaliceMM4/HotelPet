package br.edu.utfpr.hotelpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.edu.utfpr.hotelpet.dao.CoTutorDao
import br.edu.utfpr.hotelpet.dataBase.DataBase
import br.edu.utfpr.hotelpet.databinding.ActivityCadcotutorBinding
import br.edu.utfpr.hotelpet.model.CoTutor

class CadCoTutor : AppCompatActivity(){
    private val binding by lazy {
        ActivityCadcotutorBinding.inflate(layoutInflater)
    }

    private val coTutorDao: CoTutorDao by lazy {
        val db = DataBase.instancia(this)
        db.coTutorDao()
    }

    private var idCoTutor = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val botaoCadCoTutor = binding.btCadastrarCoTutor

        botaoCadCoTutor.setOnClickListener {
            val campoNomeCoTutor = binding.etNomeCoTutor
            val nomeCoTutor = campoNomeCoTutor.text.toString()

            val campoTelefoneCoTutor = binding.etTelefoneCoTutor
            val telefoneCoTutor = campoTelefoneCoTutor.text.toString()

            val campoCpfCoTutor = binding.etCPFCoTutor
            val cpfCoTutor = campoCpfCoTutor.text.toString()

            val coTutor = CoTutor(
                id = idCoTutor,
                nome = nomeCoTutor,
                telefone = telefoneCoTutor,
                cpf = cpfCoTutor
            )
            Log.i("Cad_Co_Tutor", "OnCreate: $coTutor")

            val db = DataBase.instancia(this)
            val coTutorDao = db.coTutorDao()

            if(idCoTutor > 0){
                coTutorDao.update(coTutor)
            } else{
                coTutorDao.save(coTutor)
            }

            //coTutorDao.save(coTutor)
            finish()
        }
        idCoTutor = intent.getLongExtra(CHAVE_COTUTOR, 0L)
    }

    override fun onResume() {
        super.onResume()
        coTutorDao.findById(idCoTutor)?.let {
            preencheCampos(it)
        }
    }

    private fun preencheCampos(it: CoTutor) {
        title = "Editar CoTutor"
        binding.etNomeCoTutor.setText(it.nome)
        binding.etTelefoneCoTutor.setText(it.telefone)
        binding.etCPFCoTutor.setText(it.cpf)
    }
}
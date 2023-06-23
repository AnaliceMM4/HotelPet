package br.edu.utfpr.hotelpet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.hotelpet.dao.TutorDao
import br.edu.utfpr.hotelpet.dataBase.DataBase
import br.edu.utfpr.hotelpet.databinding.ActivityCadtutorBinding

class CadTutor : AppCompatActivity(R.layout.activity_cadtutor) {
    private val binding by lazy {
        ActivityCadtutorBinding.inflate(layoutInflater)
    }

    private val tutorDao: TutorDao by lazy{
        val db = DataBase.instancia(this)
        db.tutorDao()
    }

    private var url: String? = null
    private var idTutor = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val botaoCad = binding.btCadastrarTutor
        botaoCad.setOnClickListener {
            val campoNome = binding.etNomeTutor
            val nome = campoNome.text.toString()

            val campoTelefone = binding.etTelefoneTutor
            val Telefone = campoTelefone.text.toString()

            val campoCpf = binding.etCPFTutor
            val cpf = campoCpf.text.toString()

            val campoEndereco = binding.etEnderecoTutor
            val endereco = campoEndereco.text.toString()

            val campoObjetoAnimal = binding.etNomePetdoTutor

        }
    }
}
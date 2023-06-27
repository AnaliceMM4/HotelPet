package br.edu.utfpr.hotelpet

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
<<<<<<< HEAD
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.hotelpet.databinding.ActivityCadtutorBinding

class CadTutor : AppCompatActivity() {

    private val binding by lazy{
        ActivityCadtutorBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)
        configCadCoTutor()
        Log.i("CadTutor","OnCreate: Estado criado")
=======
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.hotelpet.dao.TutorDao
import br.edu.utfpr.hotelpet.dataBase.DataBase
import br.edu.utfpr.hotelpet.databinding.ActivityCadtutorBinding
import br.edu.utfpr.hotelpet.model.Animal
import br.edu.utfpr.hotelpet.model.Tutor
import android.util.Log

class CadTutor : AppCompatActivity() {
    private val binding by lazy {
        ActivityCadtutorBinding.inflate(layoutInflater)
    }

    private val tutorDao: TutorDao by lazy{
        val db = DataBase.instancia(this)
        db.tutorDao()
    }

    private var url: String? = null
    private var idTutor = 0L

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)

        configCadCoTutor()
        configBotaoListaTutor()

        val botaoCadTutor = binding.btCadastrarTutor

        botaoCadTutor.setOnClickListener {
            val db = DataBase.instancia(this)
            val tutorDao = db.tutorDao()
            val animalDao = db.animalDao()

            val campoNome = binding.etNomeTutor
            val nome = campoNome.text.toString()

            val campoTelefone = binding.etTelefoneTutor
            val Telefone = campoTelefone.text.toString()

            val campoCpf = binding.etCPFTutor
            val cpf = campoCpf.text.toString()

            val campoEndereco = binding.etEnderecoTutor
            val endereco = campoEndereco.text.toString()

            val campoObjAnimal = binding.etNomePetdoTutor
            var animal: Animal? = animalDao.findByName(campoObjAnimal.text.toString())

            val tutor = Tutor(
                id = idTutor,
                nome = nome,
                telefone = Telefone,
                cpf = cpf,
                endereco = endereco,
                animal = animal
            )
            Log.i("Cad_Tutor", "OnCreate: $tutor")

            if(idTutor > 0){
                tutorDao.update(tutor)
            } else {
                tutorDao.save(tutor)
            }

            //tutorDao.save(tutor)
            finish()
        }

        idTutor = intent.getLongExtra(CHAVE_TUTOR, 0L)
    }

    override fun onResume() {
        super.onResume()
        tutorDao.findById(idTutor)?.let {
            preencheCampos(it)
        }
    }

    private fun preencheCampos(it: Tutor) {
        title = "Editar Tutor"
        binding.etNomeTutor.setText(it.nome)
        binding.etCPFTutor.setText(it.cpf)
        binding.etTelefoneTutor.setText(it.telefone)
        binding.etEnderecoTutor.setText(it.endereco)
        binding.etNomePetdoTutor.setText(it.animal!!.nome)//tirar dúvida com o professor sobre essa parte
    }

    fun configBotaoListaTutor(){
        val botaoListaTutor = binding.btVerTutores
        botaoListaTutor.setOnClickListener {
            val intent = Intent(this, ListaTutor::class.java)
            startActivity(intent)
        }
>>>>>>> 7b2eec34fdb87fb91e4a0fdbda3deeb46d7e8f2a
    }

    fun configCadCoTutor(){
        val botaoCadCoTutor = binding.btRegistrarCoTutor
        botaoCadCoTutor.setOnClickListener {
            val intent = Intent(this, CadCoTutor::class.java)
            startActivity(intent)
        }
    }
}
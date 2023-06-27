package br.edu.utfpr.hotelpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.edu.utfpr.hotelpet.dao.AnimalDao
import br.edu.utfpr.hotelpet.dataBase.DataBase
import br.edu.utfpr.hotelpet.databinding.ActivityCadanimalBinding
import br.edu.utfpr.hotelpet.model.Animal
import br.edu.utfpr.hotelpet.model.Servico

class CadAnimal : AppCompatActivity() {
    private val binding by lazy {
        ActivityCadanimalBinding.inflate(layoutInflater)
    }

    private val animalDao: AnimalDao by lazy {
        val db = DataBase.instancia(this)
        db.animalDao()
    }
    private var idAnimal = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val botaoCadAni = binding.btCadAnimal

        botaoCadAni.setOnClickListener {
            val db = DataBase.instancia(this)
            val animalDao = db.animalDao()
            val servicoDao = db.servicoDao()

            val campoNomeAni = binding.etNomeAnimal
            val nomeAni = campoNomeAni.text.toString()

            val campoEspecieAni = binding.etEspecieAnimal
            val especieAni = campoEspecieAni.text.toString()

            val campoPorteAni = binding.etPorteAnimal
            val porteAni = campoPorteAni.text.toString()

            val campoAndarHopedagemAni = binding.etAndarHopedagem
            val andarHopedagemAni = campoAndarHopedagemAni.text.toString()

            //talvez fazer isso aqui como um radio button ou algo do
            //sentido que de pra selecionar varios ou nos mudamos isso
            //pra pacote
            val campoServicoAni = binding.etServico
            val servicofind: Servico? = servicoDao.findByName(campoServicoAni.text.toString())
            val servico = servicofind?.nomeServico

            val animal = Animal(
                id = idAnimal,
                nome = nomeAni,
                especie = especieAni,
                porte = porteAni,
                andarHopedagem = andarHopedagemAni,
                servico = servico
            )
            Log.i("Cad_Animal", "Oncreate: $animal")

            if(idAnimal>0){
                animalDao.update(animal)
            } else{
                animalDao.save(animal)
            }

            //animalDao.save(animal)
            finish()
        }
        idAnimal = intent.getLongExtra(CHAVE_ANIMAL, 0L)
    }

    override fun onResume() {
        super.onResume()
        animalDao.findById(idAnimal)?.let {
            preencheCampos(it)
        }
    }

    private fun preencheCampos(it: Animal) {
        title = "Editar Animal"
        binding.etNomeAnimal.setText(it.nome)
        binding.etPorteAnimal.setText(it.porte)
        binding.etEspecieAnimal.setText(it.especie)
        binding.etAndarHopedagem.setText(it.andarHopedagem)
        binding.etServico.setText(it.servico)//tirar dúvida com o professor sobre essa parte
    }
}
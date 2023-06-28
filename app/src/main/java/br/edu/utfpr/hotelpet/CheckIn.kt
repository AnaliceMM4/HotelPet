package br.edu.utfpr.hotelpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.utfpr.hotelpet.dataBase.DataBase
import br.edu.utfpr.hotelpet.databinding.ActivityCheckinBinding
import br.edu.utfpr.hotelpet.model.Animal
import br.edu.utfpr.hotelpet.model.Servico
import br.edu.utfpr.hotelpet.model.Tutor

class CheckIn : AppCompatActivity() {
    private var checkInId: Long = 0L

    private val binding by lazy {
        ActivityCheckinBinding.inflate(layoutInflater)
    }

    private val tutorDao by lazy {
        val db = DataBase.instancia(this)
        db.tutorDao()
    }

    private val animalDao by lazy {
        val db = DataBase.instancia(this)
        db.animalDao()
    }

    private val servicosDao by lazy {
        val db = DataBase.instancia(this)
        db.servicoDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        checkInId = intent.getLongExtra(CHAVE_TUTOR, 0L)
    }

    override fun onResume() {
        super.onResume()
        var tutor: Tutor? = null
        var animal: Animal? = null

        tutorDao.findById(checkInId)?.let {
            tutor = it
            binding.etNomeTutorCheckIn.setText(it.nome)
        }

        val nomeAni = tutor?.animal
        if (nomeAni != null) {
            animalDao.findByName(nomeAni)?.let {
                animal = it
                binding.etAndarCheckIn.setText(it.andarHopedagem)
                binding.etNomePetCheckIn.setText(it.nome)
            }
        }

        val nomeServ = animal?.servico
        if (nomeServ != null) {
            servicosDao.findByName(nomeServ)?.let {
                binding.etServicosCheckIn.setText(it.nomeServico)
            }
        }
    }
}
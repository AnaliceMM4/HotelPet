package br.edu.utfpr.hotelpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.utfpr.hotelpet.databinding.ActivityCadanimalBinding

class CadAnimal : AppCompatActivity(R.layout.activity_cadanimal) {
    private val binding by lazy {
        ActivityCadanimalBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val botaoCadAni = binding.btCadAnimal

        botaoCadAni.setOnClickListener {
            val campoNomeAni = binding.tvNomeAnimal
            val nomeAni = campoNomeAni.text.toString()

            val campoEspecieAni = binding.tvEspecieAnimal
            val especieAni = campoEspecieAni.text.toString()

            val campoPorteAni = binding.tvPorteAnimal
            val porteAni = campoPorteAni.text.toString()

            //val campoAndarHopedagemAni = binding.tvAndarHopedagem
            //val AndarHopedagemAni = campoAndarHopedagemAni.text.toString()

            //val campoServicoAni = binding.tvServico
            //val ServicoAni = campoServicoAni.text.toString()
        }
    }
}
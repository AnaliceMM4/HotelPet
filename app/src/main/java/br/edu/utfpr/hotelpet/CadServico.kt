package br.edu.utfpr.hotelpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.edu.utfpr.hotelpet.dao.ServicosDao
import br.edu.utfpr.hotelpet.dataBase.DataBase
import br.edu.utfpr.hotelpet.databinding.ActivityCadservicoBinding
import br.edu.utfpr.hotelpet.dialog.ImgDialog
import br.edu.utfpr.hotelpet.extentions.loadImag
import br.edu.utfpr.hotelpet.model.Servico

class CadServico : AppCompatActivity() {
    private val binding by lazy {
        ActivityCadservicoBinding.inflate(layoutInflater)
    }

    private val servicoDao: ServicosDao by lazy{
        val db = DataBase.instancia(this)
        db.servicoDao()
    }

    private var url: String? = null
    private var idServico = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /*
           var nomeServico: String,
            var valorServico: Double,
            var image: String? = null */

        var botaoCadServ = binding.btCadastrarServico
        botaoCadServ.setOnClickListener {
            val campoNome = binding.etNomeServico
            val nome = campoNome.text.toString()

            val campoValor = binding.etValorServico
            val valor = campoValor.text.toString().toDouble()

            val servico = Servico(
                nomeServico = nome,
                valorServico = valor,
                image = url
            )

            Log.i("Cad_Servico", "OnCreate: $servico")
            val db = DataBase.instancia(this)
            val servicosDao = db.servicoDao()

            if(idServico > 0){
                servicosDao.update(servico)
            } else {
                servicosDao.save(servico)
            }

            //servicosDao.save(servico)
            finish()
        }

        idServico = intent.getLongExtra(CHAVE_SERVICO, 0L)

        binding.etImagem.setOnClickListener {
            ImgDialog(this).showDialog {
                imagem ->  url = imagem
                binding.etImagem.loadImag(url)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        servicoDao.findById(idServico)?.let {
            preencheCampos(it)
        }
    }

    private fun preencheCampos(it: Servico) {
        title = "Editar Servico"
        url = it.image
        binding.etImagem.loadImag(it.image)
        binding.etNomeServico.setText(it.nomeServico)
        binding.etValorServico.setText(it.valorServico.toString())
    }
}
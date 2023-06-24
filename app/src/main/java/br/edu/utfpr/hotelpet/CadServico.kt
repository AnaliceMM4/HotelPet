package br.edu.utfpr.hotelpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.utfpr.hotelpet.databinding.ActivityCadservicoBinding

class CadServico : AppCompatActivity() {
    private val binding by lazy {
        ActivityCadservicoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
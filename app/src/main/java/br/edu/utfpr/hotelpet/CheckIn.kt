package br.edu.utfpr.hotelpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.utfpr.hotelpet.databinding.ActivityCheckinBinding
import br.edu.utfpr.hotelpet.databinding.ActivityCheckoutBinding

class CheckIn : AppCompatActivity() {
    private val binding by lazy {
        ActivityCheckinBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
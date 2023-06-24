package br.edu.utfpr.hotelpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.utfpr.hotelpet.databinding.ActivityCheckoutBinding

class CheckOut : AppCompatActivity() {
    private val binding by lazy {
        ActivityCheckoutBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
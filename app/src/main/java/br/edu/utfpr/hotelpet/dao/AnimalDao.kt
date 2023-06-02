package br.edu.utfpr.hotelpet.dao

import android.util.Log
import br.edu.utfpr.hotelpet.model.Animal

class AnimalDao {
    fun add (animal: Animal){
        animais.add(animal)
        Log.i("AnimalDao", "Add: $animal")
    }

    fun findAll(): List<Animal>{
        return animais.toList()
    }

    companion object{
        private val animais = mutableListOf<Animal>()
    }
}
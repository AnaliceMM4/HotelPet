package br.edu.utfpr.hotelpet.dao

import android.util.Log
import br.edu.utfpr.hotelpet.model.FichaComportamento

class FichaComportamentoDao {
    fun add (ficha: FichaComportamento){
        fichas.add(ficha)
        Log.i("FichaDao", "Add: $ficha")
    }

    fun findAll(): List<FichaComportamento>{
        return fichas.toList()
    }

    companion object{
        private val fichas = mutableListOf<FichaComportamento>()
    }
}
package br.edu.utfpr.hotelpet.dao

import android.util.Log
import br.edu.utfpr.hotelpet.model.Servico


class ServicosDao {
    fun add (servico: Servico){
        servicos.add(servico)
        Log.i("ServicosDao", "Add: $servico")
    }

    fun findAll(): List<Servico>{
        return servicos.toList()
    }

    companion object{
        private val servicos = mutableListOf<Servico>()
    }
}
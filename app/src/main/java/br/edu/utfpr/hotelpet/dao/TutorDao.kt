package br.edu.utfpr.hotelpet.dao

import android.util.Log
import br.edu.utfpr.hotelpet.model.Tutor

class TutorDao {
    fun add (tutor: Tutor){
        tutores.add(tutor)
        Log.i("TutorDao", "Add: $tutor")
    }

    fun findAll(): List<Tutor>{
        return tutores.toList()
    }

    fun findByName(nome: String){
        var tutorEncontrado: Tutor? = null

        for(item in tutores) {
            if (item.nome == nome) {
                tutorEncontrado = item
            }
        }
        Log.i("FindByNome", "found: $tutorEncontrado")
    }

    companion object{
        private val tutores = mutableListOf<Tutor>()
    }
}
package br.edu.utfpr.hotelpet.dao

import android.util.Log
import br.edu.utfpr.hotelpet.model.CoTutor

class CoTutorDao {
    fun add (coTutor: CoTutor){
        coTutores.add(coTutor)
        Log.i("CoTutorDao", "Add: $coTutor")
    }

    companion object{
        private val coTutores = mutableListOf<CoTutor>()
    }
}
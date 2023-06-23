package br.edu.utfpr.hotelpet.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CoTutor (
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    var nome: String,
    var telefone: String,
    var cpf: String
    )
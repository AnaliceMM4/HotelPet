package br.edu.utfpr.hotelpet.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Tutor (
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    var nome: String,
    var telefone: String,
    var cpf: String,
    var endereco: String,
    var animal: Animal,
    var coTutor: CoTutor,
    )
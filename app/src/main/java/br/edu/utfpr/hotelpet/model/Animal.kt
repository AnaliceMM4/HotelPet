package br.edu.utfpr.hotelpet.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Animal(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    var nome: String,
    var especie: String,
    var porte: String,
    var andarHopedagem: String,
    var servico: String?,
    )
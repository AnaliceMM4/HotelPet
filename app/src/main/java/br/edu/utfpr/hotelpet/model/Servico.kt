package br.edu.utfpr.hotelpet.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Servico (
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    var nomeServico: String,
    var valorEstadia: Double,
    var valorServico: Double,
    var valorAdicionais: Double?,
    var image: String? = null
)
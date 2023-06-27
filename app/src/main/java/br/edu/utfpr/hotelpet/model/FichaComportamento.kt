package br.edu.utfpr.hotelpet.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FichaComportamento (
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    var hospedadoEm: String,
    var seAlimentaDe: String,
    var comportamento: String,
    var atividades: String,
    var saudeDoAnimal: String
    )
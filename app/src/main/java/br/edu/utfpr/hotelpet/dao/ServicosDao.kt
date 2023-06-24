package br.edu.utfpr.hotelpet.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.utfpr.hotelpet.model.Servico

@Dao
interface ServicosDao {
    @Query("SELECT * FROM Servico")
    fun findAll(): List<Servico>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(vararg servico: Servico)

    @Update
    fun update(vararg servico: Servico)

    @Delete
    fun delete(vararg servico: Servico)

    @Query("SELECT * FROM Servico WHERE id = :id")
    fun findById(id: Long) : Servico?

    @Query("SELECT * FROM Servico WHERE nomeServico = :nome")
    fun findByName(nome: String) : Servico?
}
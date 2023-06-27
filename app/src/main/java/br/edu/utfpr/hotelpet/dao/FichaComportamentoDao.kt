package br.edu.utfpr.hotelpet.dao

import android.util.Log
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.utfpr.hotelpet.model.FichaComportamento
import br.edu.utfpr.hotelpet.model.Servico

@Dao
interface FichaComportamentoDao {
    @Query("SELECT * FROM FichaComportamento")
    fun findAll(): List<FichaComportamento>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(vararg fichaComportamento: FichaComportamento)

    @Update
    fun update(vararg fichaComportamento: FichaComportamento)

    @Delete
    fun delete(vararg fichaComportamento: FichaComportamento)

    @Query("SELECT * FROM FichaComportamento WHERE id = :id")
    fun findById(id: Long) : FichaComportamento?
}
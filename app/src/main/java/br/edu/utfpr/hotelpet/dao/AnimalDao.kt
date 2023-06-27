package br.edu.utfpr.hotelpet.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.utfpr.hotelpet.model.Animal

@Dao
interface AnimalDao {
    @Query("SELECT * FROM Animal")
    fun findAll(): List<Animal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(vararg animal: Animal)

    @Update
    fun update(vararg animal: Animal)

    @Delete
    fun delete(vararg animal: Animal)

    @Query("SELECT * FROM Animal WHERE id = :id")
    fun findById(id: Long) : Animal?

    @Query("SELECT * FROM Animal WHERE nome = :nome")
    fun findByName(nome: String) : Animal?
}
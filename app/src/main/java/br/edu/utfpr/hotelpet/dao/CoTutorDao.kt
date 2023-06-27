package br.edu.utfpr.hotelpet.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.utfpr.hotelpet.model.CoTutor

@Dao
interface CoTutorDao {
    @Query("SELECT * FROM CoTutor")
    fun findAll(): List<CoTutor>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(vararg coTutor: CoTutor)

    @Update
    fun update(vararg coTutor: CoTutor)

    @Delete
    fun delete(vararg coTutor: CoTutor)

    @Query("SELECT * FROM CoTutor WHERE id = :id")
    fun findById(id: Long) : CoTutor?

    @Query("SELECT * FROM CoTutor WHERE nome = :nome")
    fun findByName(nome: String) : CoTutor?
}
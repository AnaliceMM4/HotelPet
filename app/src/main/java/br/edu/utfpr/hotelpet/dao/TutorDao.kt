package br.edu.utfpr.hotelpet.dao

import android.util.Log
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.utfpr.hotelpet.model.Tutor

@Dao
interface TutorDao {
    @Query("SELECT * FROM Tutor")
    fun findAll(): List<Tutor>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(vararg tutor: Tutor)

    @Update
    fun update(vararg tutor: Tutor)

    @Delete
    fun delete(vararg tutor: Tutor)

    @Query("SELECT * FROM Tutor WHERE id = :id")
    fun findById(id: Long) : Tutor?

    @Query("SELECT * FROM Tutor WHERE nome = :nome")
    fun findByName(nome: String) : Tutor?
}
package br.edu.utfpr.hotelpet.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.utfpr.hotelpet.dao.AnimalDao
import br.edu.utfpr.hotelpet.dao.CoTutorDao
import br.edu.utfpr.hotelpet.dao.FichaComportamentoDao
import br.edu.utfpr.hotelpet.dao.ServicosDao
import br.edu.utfpr.hotelpet.dao.TutorDao
import br.edu.utfpr.hotelpet.model.Animal
import br.edu.utfpr.hotelpet.model.CoTutor
import br.edu.utfpr.hotelpet.model.FichaComportamento
import br.edu.utfpr.hotelpet.model.Servico
import br.edu.utfpr.hotelpet.model.Tutor

@Database(entities = [Tutor::class, Animal::class, CoTutor::class, FichaComportamento::class, Servico::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun tutorDao(): TutorDao

    abstract fun animalDao(): AnimalDao

    abstract fun coTutorDao(): CoTutorDao

    abstract fun servicoDao(): ServicosDao

    abstract fun fichaComportamentoDao(): FichaComportamentoDao

    companion object{
        fun instancia(context: Context) : DataBase{
            return Room.databaseBuilder(
                context,
                DataBase::class.java,
                "hotelPet.db"
            ).allowMainThreadQueries().build()
        }
    }
}
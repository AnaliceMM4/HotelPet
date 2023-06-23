package br.edu.utfpr.hotelpet.dataBase

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.utfpr.hotelpet.dao.TutorDao

abstract class DataBase : RoomDatabase() {
    abstract fun tutorDao(): TutorDao

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
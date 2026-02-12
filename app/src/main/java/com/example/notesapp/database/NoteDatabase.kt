package com.example.notesapp.database
//
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import android.content.Context
//import com.example.notesapp.models.Note
//
//
//@Database(entities = [Note::class], version = 1)
//abstract class NoteDatabase : RoomDatabase() {
//
//    abstract fun getNoteDao(): NoteDao
//
//    companion object {
//
//        @Volatile
//        private var instance: NoteDatabase? = null
//        private val LOCK = Any()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
//            instance ?: createDatabase(context).also {
//                instance = it
//            }
//        }
//
//        private fun createDatabase(context: Context) =
//            Room.databaseBuilder(
//                context.applicationContext,
//                NoteDatabase::class.java,
//                "note_database"
//            ).build()
//
//    }
//}



//package com.example.notesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.models.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao() : NoteDao

    companion object {

        @Volatile
        private var INSTANCE: NoteDatabase? = null

        // This function is the single point of entry to get the database instance.
        fun getInstance(context: Context): NoteDatabase {
            // The synchronized block ensures that only one thread can create the database
            // instance at a time, preventing race conditions.
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "note_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

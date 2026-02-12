package com.example.notesapp.repository

import androidx.room.Query
import com.example.notesapp.database.NoteDatabase
import com.example.notesapp.models.Note

class NoteRepository(private val db : NoteDatabase) {

    suspend fun insertNote(note: Note) = db.getNoteDao().insertNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)

    fun getAllNote() = db.getNoteDao().getAllNotes()
    fun searchNote(query: String) = db.getNoteDao().searchNote(query)
}
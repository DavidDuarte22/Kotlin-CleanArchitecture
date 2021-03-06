package com.codingwithmitch.cleannotes.business.data.cache.abstraction

import android.provider.ContactsContract
import com.codingwithmitch.cleannotes.business.domain.model.Note

interface NoteCacheDataSource {

    suspend fun insertNote(note: Note): Long

    suspend fun deleteNote(primary: String): Int

    suspend fun deleteNotes(note: List<Note>): Int

    suspend fun updateNote(primary: String, newTitle: String, newBody: String): Int

    suspend fun searchNotes(query: String, filterAndOrder: String, page: Int): List<Note>

    suspend fun searchNoteById(primaryKey: String): Note?

    suspend fun getNumNotes(): Int

    suspend fun insertNotes(notes: List<Note>): LongArray
}
package com.codingwithmitch.cleannotes.business.data.cache.implementation

import com.codingwithmitch.cleannotes.business.data.cache.abstraction.NoteCacheDataSource
import com.codingwithmitch.cleannotes.business.domain.model.Note
import com.codingwithmitch.cleannotes.framework.datasource.cache.abstraction.NoteDaoService
import javax.inject.Singleton

@Singleton
class NoteCacheDataSourceImpl
constructor(
    private val noteDaoService: NoteDaoService
): NoteCacheDataSource {
    override suspend fun insertNote(note: Note): Long =
        noteDaoService.insertNote(note)

    override suspend fun deleteNote(primary: String): Int  =
        noteDaoService.deleteNote(primary)

    override suspend fun deleteNotes(note: List<Note>): Int  =
        noteDaoService.deleteNotes(note)

    override suspend fun updateNote(primary: String, newTitle: String, newBody: String): Int  =
        noteDaoService.updateNote(primary, newTitle, newBody)

    override suspend fun searchNotes(query: String, filterAndOrder: String, page: Int): List<Note>  =
        noteDaoService.searchNotes()

    override suspend fun searchNoteById(primaryKey: String): Note?  =
        noteDaoService.searchNoteById(primaryKey)

    override suspend fun getNumNotes(): Int  =
        noteDaoService.getNumNotes()

    override suspend fun insertNotes(notes: List<Note>): LongArray  =
        noteDaoService.insertNotes(notes)

}
package com.codingwithmitch.cleannotes.business.data.network.implementation

import com.codingwithmitch.cleannotes.business.data.network.abstraction.NoteNetworkDataSource
import com.codingwithmitch.cleannotes.business.domain.model.Note
import com.codingwithmitch.cleannotes.framework.datasource.network.abstraction.NoteFirestoreService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteNetworkDataImpl
@Inject
constructor(
    private val firestoreService: NoteFirestoreService
): NoteNetworkDataSource

{
    override suspend fun insertOrUpdateNote(note: Note) =
        firestoreService.insertOrUpdateNote(note)

    override suspend fun deleteNote(primaryKey: String)  =
        firestoreService.deleteNote(primaryKey)

    override suspend fun insertDeletedNote(note: Note)  =
        firestoreService.insertDeletedNote(note)

    override suspend fun insertDeletedNotes(notes: List<Note>)  =
        firestoreService.insertDeletedNotes(notes)

    override suspend fun deleteDeletedNote(note: Note) =
        firestoreService.deleteDeletedNote(note)

    override suspend fun getDeletedNote(): List<Note> =
        firestoreService.getDeletedNote()

    override suspend fun deleteAllNotes() =
        firestoreService.deleteAllNotes()

    override suspend fun searchNote(note: Note): Note? =
        firestoreService.searchNote(note)

    override suspend fun getAllNotes(): List<Note> =
        firestoreService.getAllNotes()

    override suspend fun insertOrUpdateNotes(notes: List<Note>) =
        firestoreService.insertOrUpdateNotes(notes)
}
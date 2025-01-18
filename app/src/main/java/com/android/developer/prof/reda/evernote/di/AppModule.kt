package com.android.developer.prof.reda.evernote.di

import android.content.Context
import com.android.developer.prof.reda.evernote.database.NoteDao
import com.android.developer.prof.reda.evernote.database.NoteDatabase
import com.android.developer.prof.reda.evernote.repositories.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(context: Context) = NoteDatabase.getDatabase(context)

    @Provides
    @Singleton
    fun provideNoteDao(database: NoteDatabase) = database.noteDao()

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao) = NoteRepository(noteDao)
}
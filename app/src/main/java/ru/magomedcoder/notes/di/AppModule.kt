package ru.magomedcoder.notes.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import ru.magomedcoder.notes.data.local.NoteDatabase
import ru.magomedcoder.notes.domain.AppRepository
import android.app.Application
import androidx.room.Room
import ru.magomedcoder.notes.data.repository.NoteRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(application: Application): NoteDatabase {
        return Room
            .databaseBuilder(application, NoteDatabase::class.java, "ru_magomedcoder_note_db")
            .build()
    }

    @Singleton
    @Provides
    fun provideNoteRepository(db: NoteDatabase): AppRepository {
        return NoteRepositoryImpl(db.dao)
    }

}
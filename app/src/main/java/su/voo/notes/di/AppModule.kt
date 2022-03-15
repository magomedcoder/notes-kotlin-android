package su.voo.notes.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import su.voo.notes.data.local.NoteDatabase
import su.voo.notes.domain.AppRepository
import android.app.Application
import androidx.room.Room
import su.voo.notes.data.repository.NoteRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(application: Application): NoteDatabase {
        return Room
            .databaseBuilder(application, NoteDatabase::class.java, "voo_note_db")
            .build()
    }

    @Singleton
    @Provides
    fun provideNoteRepository(db: NoteDatabase): AppRepository {
        return NoteRepositoryImpl(db.dao)
    }

}
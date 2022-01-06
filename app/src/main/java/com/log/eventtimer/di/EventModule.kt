package com.log.eventtimer.di

import android.app.Application
import androidx.room.Room
import com.log.eventtimer.data.event.EventConverter
import com.log.eventtimer.data.event.EventDatabase
import com.log.eventtimer.data.repository.EventRepositoryImpl
import com.log.eventtimer.domain.repository.EventRepository
import com.log.eventtimer.domain.use_cases.DeleteEventUseCase
import com.log.eventtimer.domain.use_cases.GetAllEventsUseCase
import com.log.eventtimer.domain.use_cases.SaveEventUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EventModule {

    @Provides
    @Singleton
    fun provideEventDatabase(app: Application): EventDatabase {
        return Room.databaseBuilder(
            app,
            EventDatabase::class.java, "eventDb",
        )
            .addTypeConverter(EventConverter())
            .build()
    }

    @Provides
    @Singleton
    fun provideEventRepositoryImplementation(
        db: EventDatabase,
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
    ): EventRepository = EventRepositoryImpl(
        dao = db.dao,
        ioDispatcher = ioDispatcher,
    )


    @Provides
    @Singleton
    fun provideSaveEventUseCase(
        repository: EventRepository,
        @ApplicationScope externalScope: CoroutineScope,
    ): SaveEventUseCase =
        SaveEventUseCase(
            repository = repository,
            externalScope = externalScope,
        )

    @Provides
    @Singleton
    fun provideGetAllEventsUseCase(
        repository: EventRepository,
        @DefaultDispatcher defaultDispatcher: CoroutineDispatcher,
    ): GetAllEventsUseCase =
        GetAllEventsUseCase(
            repository = repository,
            defaultDispatcher = defaultDispatcher,
        )

    @Provides
    @Singleton
    fun provideDeleteEventUseCase(
        repository: EventRepository,
        @ApplicationScope externalScope: CoroutineScope,
    ): DeleteEventUseCase =
        DeleteEventUseCase(
            repository = repository,
            externalScope = externalScope,
        )

}
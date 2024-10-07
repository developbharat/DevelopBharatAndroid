package com.developbharat.developbharat.common.modules

import android.content.Context
import com.developbharat.developbharat.common.core.SharedStoreKeys
import com.developbharat.developbharat.common.domain.database.MainDatabase
import com.developbharat.developbharat.common.domain.store.ISharedStore
import com.developbharat.developbharat.common.domain.store.SharedStore
import com.developbharat.developbharat.common.repos.device.DeviceRepository
import com.developbharat.developbharat.common.repos.device.IDeviceRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.security.SecureRandom
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RootModule {
    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun providesSharedStore(@ApplicationContext() context: Context, gson: Gson): ISharedStore {
        val sharedPreferences = context.getSharedPreferences("SHARED_STORE", Context.MODE_PRIVATE)
        return SharedStore(sharedPreferences, gson)
    }

    @Provides
    @Singleton
    fun providesDatabaseInstance(@ApplicationContext() context: Context, sharedStore: ISharedStore): MainDatabase {
        val password = if (sharedStore.isValueAvailable(SharedStoreKeys.DATABASE_PASSWORD)) {
            sharedStore.useValue(SharedStoreKeys.DATABASE_PASSWORD, String::class.java)
        } else {
            val password =
                (1..12).joinToString("") { "%02x".format(SecureRandom().nextInt(255)) }
            sharedStore.setValue(SharedStoreKeys.DATABASE_PASSWORD, password)
            password
        }
        return MainDatabase.createDatabaseInstance(context, password)
    }

    @Provides
    @Singleton
    fun providesAndroidRepository(@ApplicationContext() context: Context): IDeviceRepository {
        return DeviceRepository(context)
    }
}
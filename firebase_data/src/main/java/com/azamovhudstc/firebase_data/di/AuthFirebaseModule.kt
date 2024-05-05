package com.azamovhudstc.firebase_data.di

import android.content.Context
import com.azamovhudstc.firebase_data.repository.AuthRepository
import com.azamovhudstc.firebase_data.repository.HomeRepository
import com.azamovhudstc.firebase_data.repository.imp.AuthRepositoryImpl
import com.azamovhudstc.firebase_data.repository.imp.HomeRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthFirebaseModule {

    @Provides
    fun provideAuthRepository(
        firebaseAuth: FirebaseAuth,
        firebaseDatabase: FirebaseDatabase,
        @ApplicationContext context: Context
    ): AuthRepository {
        return AuthRepositoryImpl(firebaseDatabase, context, firebaseAuth)
    }

    @Provides
    fun provideHomeRepository(
        firebaseDatabase: FirebaseDatabase,
    ): HomeRepository {
        return HomeRepositoryImpl(firebaseDatabase )
    }

}
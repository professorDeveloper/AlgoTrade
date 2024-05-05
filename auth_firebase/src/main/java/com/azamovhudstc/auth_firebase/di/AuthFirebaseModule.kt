package com.azamovhudstc.auth_firebase.di

import android.content.Context
import com.azamovhudstc.auth_firebase.repository.AuthRepository
import com.azamovhudstc.auth_firebase.repository.imp.AuthRepositoryImpl
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

}
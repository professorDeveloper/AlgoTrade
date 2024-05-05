package com.azamovhudstc.firebase_data.repository.imp

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import com.azamovhudstc.firebase_data.repository.AuthRepository
import com.azamovhudstc.firebase_data.request.LoginRequest
import com.azamovhudstc.firebase_data.request.RegisterRequest
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    val firebaseDatabase: FirebaseDatabase,
    @ApplicationContext val application: Context,
    val firebaseAuth: FirebaseAuth,
) : AuthRepository {
    override fun registerRequest(registerRequest: RegisterRequest) = callbackFlow<Result<String>> {
        // Register user with Firebase Authentication
        firebaseAuth.createUserWithEmailAndPassword(registerRequest.email, registerRequest.password)
            .addOnCompleteListener { authTask ->
                if (authTask.isSuccessful) {
                    val userId = authTask.result?.user?.uid ?: ""
                    val usersRef: DatabaseReference = firebaseDatabase.reference.child("users")

                    val userData = hashMapOf(
                        "email" to registerRequest.email,
                        "password" to registerRequest.password,
                        "name" to registerRequest.name,
                        "lastName" to registerRequest.lastName,
                        "deviceId" to getDeviceId(),
                        "profilePic" to "https://static.vecteezy.com/system/resources/thumbnails/009/292/244/small/default-avatar-icon-of-social-media-user-vector.jpg"
                    )
                    usersRef.child(userId).setValue(userData)
                        .addOnCompleteListener { dbTask ->
                            if (dbTask.isSuccessful) {
                                trySend(Result.success(userId))
                            } else {
                                // If writing user data to Firebase Database fails
                                trySend(
                                    Result.failure(
                                        dbTask.exception ?: Exception("Unknown error")
                                    )
                                )
                            }
                        }
                } else {
                    // If user creation with Firebase Authentication fails
                    trySend(Result.failure(authTask.exception ?: Exception("Unknown error")))
                }
            }

        awaitClose()
    }

    override fun loginRequest(loginRequest: LoginRequest): Flow<Result<String>> = callbackFlow {
        val usersRef: DatabaseReference = firebaseDatabase.reference.child("users")

        usersRef.orderByChild("email").equalTo(loginRequest.email)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        val userData = dataSnapshot.children.first().getValue() as Map<*, *>
                        val uid = userData["uid"] as String?

                        // Perform Firebase authentication
                        firebaseAuth.signInWithEmailAndPassword(
                            loginRequest.email,
                            loginRequest.password
                        )
                            .addOnCompleteListener { authTask ->
                                if (authTask.isSuccessful) {
                                    trySend(Result.success(uid ?: ""))
                                } else {
                                    trySend(
                                        Result.failure(
                                            authTask.exception ?: Exception("Unknown error")
                                        )
                                    )
                                }
                            }
                    } else {
                        trySend(Result.failure(Exception("User not found")))
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    trySend(Result.failure(databaseError.toException()))
                }
            })

        awaitClose()
    }

    @SuppressLint("HardwareIds")
    private fun getDeviceId(): String {
        // Here you can obtain the device unique identifier
        // For example, you can use the Android ID
        return Settings.Secure.getString(application.contentResolver, Settings.Secure.ANDROID_ID)
    }

}
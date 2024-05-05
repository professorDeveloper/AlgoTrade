package com.azamovhudstc.firebase_data.repository.imp

import com.azamovhudstc.firebase_data.repository.HomeRepository
import com.azamovhudstc.firebase_data.response.ProfileResponse
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val database: FirebaseDatabase) :
    HomeRepository {
    override fun loadProfile(token: String) = callbackFlow<Result<ProfileResponse>> {
        // Reference to the user's profile node in Firebase
        val profileRef = database.reference.child("users").child(token)

        profileRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val dataSnapshot = task.result
                if (dataSnapshot != null && dataSnapshot.exists()) {
                    val profile = dataSnapshot.getValue(ProfileResponse::class.java)
                    if (profile != null) {
                        trySend(Result.success(profile))
                    } else {
                        trySend(Result.failure(Exception("Profile data is null")))
                    }
                } else {
                    trySend(Result.failure(Exception("DataSnapshot is null or doesn't exist")))
                }
            } else {
                trySend(Result.failure(task.exception ?: Exception("Unknown error")))
            }
        }

        awaitClose()
    }

}
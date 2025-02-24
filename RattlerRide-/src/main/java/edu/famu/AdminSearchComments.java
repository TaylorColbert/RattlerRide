package edu.famu;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class AdminSearchComments {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        Firestore db = FirestoreConfig.getFirestore(); // Initialize Firestore

        // Get the student document reference
        DocumentReference studentRef = db.collection("students").document("WSq9MLb9mmrjjJiXy1u5"); // The student document reference

        CollectionReference commentsRef = db.collection("comments"); // Get 'comments' collection
        Query query = commentsRef.whereEqualTo("student_id", studentRef); // Query using student reference

        ApiFuture<QuerySnapshot> querySnapshot = query.get(); // Execute query

        // Debugging: Print all comments found
        if (!querySnapshot.get().isEmpty()) {
            System.out.println("Comments found for studentId: " + studentRef.getId());
            for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                System.out.println("Comment Found: " + document.getData());
            }
        } else {
            System.out.println("⚠️ No comments found for studentId: " + studentRef.getId());

        }
    }
}

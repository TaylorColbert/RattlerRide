package edu.famu;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class AdminSearchStudent {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        Firestore db = FirestoreConfig.getFirestore();

        String studentEmail = "123@aol.com"; // Admin provides this email
        CollectionReference studentsRef = db.collection("students");

        Query query = studentsRef.whereEqualTo("email", studentEmail);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        if (!querySnapshot.get().isEmpty()) {
            for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                System.out.println("Student Found: " + document.getData());
            }
        } else {
            System.out.println("No student found with this email.");
        }
    }
}

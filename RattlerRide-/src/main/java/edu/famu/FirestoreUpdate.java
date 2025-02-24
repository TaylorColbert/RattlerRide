package edu.famu;

import com.google.cloud.firestore.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FirestoreUpdate {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        Firestore db = FirestoreConfig.getFirestore();
        DocumentReference docRef = db.collection("students").document("F3zluuivmA5TJVGETEXw");

        Map<String, Object> updates = new HashMap<>();
        updates.put("name", "John Doe");
        updates.put("email", "123@aol.com");

        docRef.update(updates).get();
        System.out.println("Document updated successfully!");
    }
}


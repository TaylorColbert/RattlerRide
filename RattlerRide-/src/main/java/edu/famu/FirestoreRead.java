package edu.famu;

import com.google.cloud.firestore.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class FirestoreRead {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        Firestore db = FirestoreConfig.getFirestore();
        DocumentReference docRef = db.collection("admin").document("student_id");
        DocumentSnapshot document = docRef.get().get();

        if (document.exists()) {
            System.out.println("User Data: " + document.getData());
        } else {
            System.out.println("No such document!");
        }
    }
}


package edu.famu;

import com.google.cloud.firestore.*;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class FirestoreDelete {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        Firestore db = FirestoreConfig.getFirestore();
        DocumentReference docRef = db.collection("students").document("S006");

        docRef.delete().get();
        System.out.println("Document deleted successfully!");
    }
}


package edu.famu.rattler_ride; // ✅ Make sure this matches FirestoreQueries.java

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.IOException;
import java.io.InputStream;

public class FirebaseInitializer {
    private static Firestore db;

    public static Firestore initialize() throws IOException {
        if (db == null) {
            InputStream serviceAccount = FirebaseInitializer.class
                    .getClassLoader()
                    .getResourceAsStream("serviceAccountKey.json");

            if (serviceAccount == null) {
                throw new IOException("Service account file not found in resources folder!");
            }

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setProjectId("rattler-ride")  // ✅ Make sure this matches your Firebase Console project ID
                    .build();

            FirebaseApp.initializeApp(options);
            db = FirestoreClient.getFirestore();
        }
        return db;
    }
}

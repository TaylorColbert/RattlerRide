package edu.famu;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import java.io.FileInputStream;
import java.io.IOException;

public class FirestoreConfig {
    private static Firestore db;

    public static Firestore getFirestore() throws IOException {
        if (db == null) {
            // Update the path if your JSON is not in the project root.
            FileInputStream serviceAccount = new FileInputStream("src/main/java/edu/famu/serviceAccountKey.json");
            FirestoreOptions options = FirestoreOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            db = options.getService();
        }
        return db;
    }
}


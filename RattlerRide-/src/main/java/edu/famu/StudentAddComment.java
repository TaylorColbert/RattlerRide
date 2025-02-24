package edu.famu;

import com.google.cloud.firestore.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class StudentAddComment {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        Firestore db = FirestoreConfig.getFirestore(); // Get Firestore instance

        String studentId = "S002"; // Unique ID of the student (change as needed)
        String commentText = "Loved the scooter! Battery held up well!"; // Replace with actual comment

        // Reference to "comments" collection (Firestore will create if it doesn't exist)
        DocumentReference commentRef = db.collection("comments").document(); // Auto-generate a unique ID

        // Create a map to store comment data
        Map<String, Object> commentData = new HashMap<>();
        commentData.put("studentId", studentId); // Associate comment with student ID
        commentData.put("commentText", commentText); // Store the comment text
        commentData.put("timestamp", FieldValue.serverTimestamp()); // Store current timestamp

        // Save the comment in Firestore
        commentRef.set(commentData).get();
        System.out.println("Comment added successfully!");
    }
}

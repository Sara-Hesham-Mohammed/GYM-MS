package server;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import java.util.List;
import org.bson.Document;

public class Database {
    private MongoClient client;
    private MongoDatabase database;

    // Constructor initializes MongoClient and connects to the database
    public Database() {
        // Connect to MongoDB server
        client = MongoClients.create("mongodb://localhost:27017"); // Adjust connection string if needed
        // Connect to the database
        database = client.getDatabase("GymManagementDB");
    }

    
    // Method to save a notification to the 'notifications' collection
    public void saveNotification(String notification) {
        // Get the 'notifications' collection (it will be created if it doesn't exist)
        MongoCollection<Document> collection = database.getCollection("notifications");

        // Create a document to insert
        Document doc = new Document("notification", notification)
                       .append("timestamp", System.currentTimeMillis());

        // Insert the document into the collection
        collection.insertOne(doc);

        System.out.println("Notification saved: " + notification);
    }
    
     // Method to load the class timetable from the database
    /*private void loadClassTimetable() {
        List<Document> classes = db.getClasses();
        for (Document classDoc : classes) {
            Object[] row = {
                classDoc.getString("classID"),
                classDoc.getString("classType"),
                classDoc.getString("time"),
                classDoc.getInteger("capacity"),
                classDoc.getString("trainer")
            };
            tableModel.addRow(row);
        }
    }*/
}


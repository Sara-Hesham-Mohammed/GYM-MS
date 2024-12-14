package Server;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static MongoClient client;
    private static MongoDatabase database;

    // Singleton instance
    private static Database instance;

    // Constructor initializes MongoClient and connects to the database
    Database() {
        if (client == null) {
            client = new MongoClient("localhost", 27017); // Connect to MongoDB
            database = client.getDatabase("Gym"); // Database name
        }
    }

    // Static method to get the database instance (Singleton)
    public static Database getDatabase() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    // Initialize database and create collections if they don't exist
    public void initializeDatabase() {
        try {
            if (!collectionExists("GymMembers")) {
                database.createCollection("GymMembers");
                System.out.println("Collection 'GymMembers' created.");
            }
            if (!collectionExists("notifications")) {
                database.createCollection("notifications");
                System.out.println("Collection 'notifications' created.");
            }
            if (!collectionExists("ClassTimetables")) {
                database.createCollection("ClassTimetables");
                System.out.println("Collection 'ClassTimetables' created.");
            }
            if (!collectionExists("Facilities")) {
                database.createCollection("Facilities");
                System.out.println("Collection 'Facilities' created.");
            }
        } catch (Exception e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }

    private boolean collectionExists(String collectionName) {
        try {
            for (String name : database.listCollectionNames()) {
                if (name.equalsIgnoreCase(collectionName)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error checking collection existence: " + e.getMessage());
        }
        return false;
    }

    public void addFacility(Facility facility) {
        try {
            MongoCollection<Document> facilityCollection = database.getCollection("Facilities");
            Document doc = new Document("facilityID", facility.getFacilityID())
                    .append("facilityTitle", facility.getFacilityTitle())
                    .append("startTime", facility.getFacilityStartTime())
                    .append("endTime", facility.getFacilityEndTime())
                    .append("price", facility.getFacilityPrice())
                    .append("noOfSeatsAvailable", facility.getNoOfSeatsAvailable())
                    .append("facilityInfo", facility.getFacilityInfo());
            facilityCollection.insertOne(doc);
            System.out.println("Facility created successfully");
        } catch (Exception e) {
            System.err.println("Error while adding facility: " + e.getMessage());
        }
    }

    public void modifyFacility(Facility facility) {
        try {
            MongoCollection<Document> facilityCollection = database.getCollection("Facilities");
            facilityCollection.updateOne(
                    Filters.eq("facilityID", facility.getFacilityID()),
                    Updates.combine(
                            Updates.set("facilityTitle", facility.getFacilityTitle()),
                            Updates.set("startTime", facility.getFacilityStartTime()),
                            Updates.set("endTime", facility.getFacilityEndTime()),
                            Updates.set("price", facility.getFacilityPrice()),
                            Updates.set("noOfSeatsAvailable", facility.getNoOfSeatsAvailable()),
                            Updates.set("facilityInfo", facility.getFacilityInfo())
                    )
            );
            System.out.println("Facility updated successfully");
        } catch (Exception e) {
            System.err.println("Error while modifying facility: " + e.getMessage());
        }
    }

    public void deleteFacility(int facilityID) {
        try {
            MongoCollection<Document> facilityCollection = database.getCollection("Facilities");
            facilityCollection.deleteOne(Filters.eq("facilityID", facilityID));
            System.out.println("Facility with ID " + facilityID + " deleted successfully");
        } catch (Exception e) {
            System.err.println("Error while deleting facility: " + e.getMessage());
        }
    }

    public List<Document> viewFacilities() {
        try {
            MongoCollection<Document> facilityCollection = database.getCollection("Facilities");
            return facilityCollection.find().into(new ArrayList<>());
        } catch (Exception e) {
            System.err.println("Error while viewing facilities: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void requestNutritionPlan(Member member) {
        try {
            MongoCollection<Document> memberCollection = database.getCollection("GymMembers");
            Document doc = new Document("memberID", member.getMemberID())
                    .append("fitnessGoal", member.getFitnessGoal())
                    .append("trainingLevel", member.getTrainingLevel())
                    .append("nutritionPlanRequested", true);
            memberCollection.insertOne(doc);
            System.out.println("Nutrition plan request added for member: " + member.getMemberID());
        } catch (Exception e) {
            System.err.println("Error while adding nutrition plan request: " + e.getMessage());
        }
    }

    public void reserveFacility(int facilityID, int noOfSeats) {
        try {
            MongoCollection<Document> facilityCollection = database.getCollection("Facilities");
            facilityCollection.updateOne(
                    Filters.eq("facilityID", facilityID),
                    Updates.inc("noOfSeatsAvailable", -noOfSeats) // Decrement available seats by noOfSeats
            );
            System.out.println("Facility reserved successfully");
        } catch (Exception e) {
            System.err.println("Error while reserving facility: " + e.getMessage());
        }
    }

    public void updateNutritionPlan(int memberID) {
        try {
            MongoCollection<Document> memberCollection = database.getCollection("GymMembers");
            memberCollection.updateOne(
                    Filters.eq("memberID", memberID),
                    Updates.set("nutritionPlanProvided", true)
            );
            System.out.println("Nutrition plan updated for member: " + memberID);
        } catch (Exception e) {
            System.err.println("Error while updating nutrition plan: " + e.getMessage());
        }
    }

    public void bookFacility(Member member, Facility facility, int noOfSeats) {
        try {
            // Call the existing reserveFacility method
            reserveFacility(facility.getFacilityID(), noOfSeats);
            
            // Now record the booking into the database
            MongoCollection<Document> bookingCollection = database.getCollection("Bookings");
            Document bookingDoc = new Document("memberID", member.getMemberID())
                    .append("facilityID", facility.getFacilityID())
                    .append("noOfSeats", noOfSeats)
                    .append("bookingDate", System.currentTimeMillis()); // Store booking date as timestamp
            bookingCollection.insertOne(bookingDoc);
            System.out.println("Facility successfully booked by Member " + member.getMemberID());
        } catch (Exception e) {
            System.err.println("Error while booking facility: " + e.getMessage());
        }
    }
    public List<Document> viewRequestedNutritionPlans() {
        try {
            MongoCollection<Document> memberCollection = database.getCollection("GymMembers");
            return memberCollection.find(Filters.eq("nutritionPlanRequested", true)).into(new ArrayList<>());
        } catch (Exception e) {
            System.err.println("Error while viewing nutrition plan requests: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // New function to update approval status for nutrition plan
    public void updateApproval(int memberID) {
        try {
            MongoCollection<Document> memberCollection = database.getCollection("GymMembers");
            memberCollection.updateOne(
                    Filters.eq("memberID", memberID),
                    Updates.set("nutritionPlanApproved", true) // Add approval status
            );
            System.out.println("Nutrition plan approval updated for member: " + memberID);
        } catch (Exception e) {
            System.err.println("Error while updating nutrition plan approval: " + e.getMessage());
        }
    }
}

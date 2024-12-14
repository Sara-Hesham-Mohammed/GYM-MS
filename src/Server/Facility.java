package Server;

import java.util.ArrayList;
import org.bson.Document;

public class Facility implements ReadOnlyFacility {
    private int facilityID;
    private String facilityTitle;
    private String facilityStartTime;
    private String facilityEndTime;
    private float facilityPrice;
    private int noOfSeatsAvailable;
    private String facilityInfo;

    public Facility() {}

    // Constructor
    public Facility(int facilityID, String facilityTitle, 
            String facilityStartTime, String facilityEndTime, float facilityPrice,  int noOfSeatsAvailable, String facilityInfo) {
        this.facilityID = facilityID;
        this.facilityTitle = facilityTitle;
        this.facilityStartTime = facilityStartTime;
        this.facilityEndTime = facilityEndTime;
        this.facilityPrice = facilityPrice;
        this.noOfSeatsAvailable = noOfSeatsAvailable;
        this.facilityInfo = facilityInfo;
    }

    // Setters and Getters
    @Override
    public int getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(int facilityID) {
        this.facilityID = facilityID;
    }

    public String getFacilityTitle() {
        return facilityTitle;
    }

    public void setFacilityTitle(String facilityTitle) {
        this.facilityTitle = facilityTitle;
    }

    public String getFacilityStartTime() {
        return facilityStartTime;
    }

    public void setFacilityStartTime(String facilityStartTime) {
        this.facilityStartTime = facilityStartTime;
    }

    public String getFacilityEndTime() {
        return facilityEndTime;
    }

    public void setFacilityEndTime(String facilityEndTime) {
        this.facilityEndTime = facilityEndTime;
    }

    public float getFacilityPrice() {
        return facilityPrice;
    }

    public void setFacilityPrice(float facilityPrice) {
        this.facilityPrice = facilityPrice;
    }

    public int getNoOfSeatsAvailable() {
        return noOfSeatsAvailable;
    }

    public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
        this.noOfSeatsAvailable = noOfSeatsAvailable;
    }

    public String getFacilityInfo() {
        return facilityInfo;
    }

    public void setFacilityInfo(String facilityInfo) {
        this.facilityInfo = facilityInfo;
    }

    // Create Facilities method
    public void addFacility(Facility facility, int adminID) {
        Database db = Database.getDatabase();  // Get the instance of Database
        db.addFacility(facility);  // Using the instance method to add the facility
    }

    // Delete Facility details
    public void deleteFacility(int facilityID) {
        Database db = Database.getDatabase();  // Get the instance of Database
        db.deleteFacility(facilityID);  // Using the instance method to delete the facility
    }

    // Modify Facility method
    public void modifyFacility(Facility facility, int adminID) {
        Database db = Database.getDatabase();  // Get the instance of Database
        db.modifyFacility(facility);  // Using the instance method to modify the facility
    }

    @Override
    public boolean checkAvailability(int noOfSeats) {
        return noOfSeatsAvailable >= noOfSeats;
    }

    @Override
    public void bookSeats(int facilityID, int noOfSeats) {
        Database db = Database.getDatabase();  // Get the instance of Database
        db.reserveFacility(facilityID, noOfSeats);  // Using the instance method to reserve facility
        noOfSeatsAvailable -= noOfSeats;
    }

    @Override
    public void cancelBook(int noOfSeats) {
        noOfSeatsAvailable += noOfSeats;
    }

    // Get all Facilities
    /*
    public ArrayList<Facility> viewFacilities() {
        Database db = Database.getDatabase();
        return ReadOnlyFacility.viewFacilities();
    }*/

    @Override
    public ArrayList<Facility> viewMyFacilities(int candidateID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

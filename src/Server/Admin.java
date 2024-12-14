package Server;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private int adminID;
    private static Admin adminInstance;
    private GymClass className; // GymClass associated with Admin
    private Locker locker;
    private Facility Facilities;

    // List to store observers
    private List<Observer> observers;

    public Admin() {
        this.Facilities = new Facility();
        this.observers = new ArrayList<>();
    }

    public Admin(GymClass className, Locker locker) {
        this.className = className;
        this.locker = locker;
        this.Facilities = new Facility();
        this.observers = new ArrayList<>();
    }

    // Singleton for Admin instance
    /* public static Admin getAdminInstance() {
        return adminInstance;
    }*/
    
    public static Admin getAdminInstance() {
        if (adminInstance == null) {
            adminInstance = new Admin();
        }
        return adminInstance;
    }

    

    public static void setAdminInstance(Admin adminInstance) {
        Admin.adminInstance = adminInstance;
    }

    public GymClass getClassName() {
        return className;
    }

    // Updated to accept a GymClass object instead of String
    public void setClassName(GymClass className) {
        this.className = className;  // Update the GymClass object
        notifyObservers("Class updated to: " + className.getClassName()); // Notify observers about the update
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public Facility getFacilities() {
        return Facilities;
    }

    public void setFacilities(Facility Facilities) {
        this.Facilities = Facilities;
    }

    // Methods for managing facilities
    public void addFacility(Facility e) {
        Facilities.addFacility(e, adminID);
    }

    public ArrayList<Facility> viewMyFacilities() {
        return Facilities.viewMyFacilities(adminID);
    }

    public void modifyFacility(Facility e) {
        Facilities.modifyFacility(e, adminID);
    }

    public void deleteFacility(int FacilityID) {
        Facilities.deleteFacility(FacilityID);
    }

    // Observer-related methods
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message); // Notify each observer about the update
        }
    }
}

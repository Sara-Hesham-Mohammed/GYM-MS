package Server;

import java.util.ArrayList;
import org.bson.Document;

public class Member extends User implements Observer {
    private MembershipPlan membershipPlan;
    private int attendanceRecord;
    private Locker locker;
    private HealthInfo healthInfo;
    private GymClass gymClass;
    private WorkoutPlan workoutPlan;
    private NutritionPlan nutritionPlan;
    private ArrayList<Booking> bookings;
    private ArrayList<Payment> payments;
    private Reservation reservations;

    // Attributes
    private int memberID;
    private boolean nutritionPlanNum; // true for 1, false for 2
    private String fitnessGoal;
    private int trainingLevel;
    private Facility facilities;
    private String dateOfBirth; // Store dateOfBirth as String in "dd/MM/yyyy" format (or LocalDate if preferred)

    // Default constructor
    public Member() {
        this.reservations = new Reservation();
    }

    // Parameterized constructor
    public Member(int memberID, String fitnessGoal, int trainingLevel, String name, char gender, String email,
                  String dateOfBirth, String username, String password,
                  MembershipPlan membershipPlan, int attendanceRecord, Locker locker,
                  HealthInfo healthInfo, GymClass gymClass, WorkoutPlan workoutPlan,
                  NutritionPlan nutritionPlan, ArrayList<Booking> bookings, ArrayList<Payment> payments) {
        // super(name, gender, email, dateOfBirth, username, password);
        this.memberID = memberID;
        this.fitnessGoal = fitnessGoal;
        this.trainingLevel = trainingLevel;
        this.dateOfBirth = dateOfBirth;  // Set date of birth here
        this.membershipPlan = membershipPlan;
        this.attendanceRecord = attendanceRecord;
        this.locker = locker;
        this.healthInfo = healthInfo;
        this.gymClass = gymClass;
        this.workoutPlan = workoutPlan;
        this.nutritionPlan = nutritionPlan;
        this.bookings = bookings;
        this.payments = payments;
    }

    // Getters and setters
    public Reservation getReservations() {
        return reservations;
    }

    public void setReservations(Reservation reservations) {
        this.reservations = reservations;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    public int getTrainingLevel() {
        return trainingLevel;
    }

    public void setTrainingLevel(int trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    public Facility getFacilities() {
        return facilities;
    }

    public void setFacilities(Facility facilities) {
        this.facilities = facilities;
    }

    public String getDateOfBirth() {
        return dateOfBirth;  // Return date of birth as String
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public MembershipPlan getMembershipPlan() {
        return membershipPlan;
    }

    public void setMembershipPlan(MembershipPlan membershipPlan) {
        this.membershipPlan = membershipPlan;
    }

    public int getAttendanceRecord() {
        return attendanceRecord;
    }

    public void setAttendanceRecord(int attendanceRecord) {
        this.attendanceRecord = attendanceRecord;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public HealthInfo getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(HealthInfo healthInfo) {
        this.healthInfo = healthInfo;
    }

    public GymClass getGymClass() {
        return gymClass;
    }

    public void setGymClass(GymClass gymClass) {
        this.gymClass = gymClass;
    }

    public WorkoutPlan getWorkoutPlan() {
        return workoutPlan;
    }

    public void setWorkoutPlan(WorkoutPlan workoutPlan) {
        this.workoutPlan = workoutPlan;
    }

    public NutritionPlan getNutritionPlan() {
        return nutritionPlan;
    }

    public void setNutritionPlan(NutritionPlan nutritionPlan) {
        this.nutritionPlan = nutritionPlan;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    // Methods related to reservations
    public ArrayList<Facility> viewFacilities(int candidateID) {
        return reservations.getFacility().viewMyFacilities(candidateID);
    }

    public boolean makeReservation() {
        return reservations.makeReservation(this);
    }

    // Implementation of Observer interface
    @Override
    public void update(String message) {
        // Print or handle the received notification
        System.out.println("Member ID: " + memberID + " received update: " + message);
        // Optionally, add logic to update member's state or display the message in the GUI
    }

    // Request nutrition plan
    public void requestNutritionPlan() {
        Database.getDatabase().requestNutritionPlan(this); // Pass the current member instance to the database
    }
}

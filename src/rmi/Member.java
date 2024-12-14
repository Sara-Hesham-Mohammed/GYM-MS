/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Collections.list;

/**
 *
 * @author Sara
 */
public class Member extends User implements MemberInterface {

    private MembershipPlan membershipPlan;
    private int attendanceRecord;
    private Locker locker;
    private HealthInfo healthInfo;
    private ArrayList<GymClass> gymClasses;
    private WorkoutPlan workoutPlan;
    private NutritionPlan nutritionPlan;
    private ArrayList<Booking> bookings;
    private ArrayList<Payment> payments;
    private Calendar joinDate = Calendar.getInstance();
    private Reservation reservations;
    
    private boolean nutritionPlanNum; // true for 1, false for 2
    private String fitnessGoal;
    private int trainingLevel;
    private Facility facilities;
    private String dateOfBirth; 

    public Member() {

this.reservations = new Reservation();
    }

    //temporary code for constructor bc idk how it is done
    public Member(int id, String name, int age, String email, String username, String password, String gender,
            MembershipPlan membershipPlan, int attendanceRecord, Locker locker, HealthInfo healthInfo,
            ArrayList<GymClass> gymClasses, WorkoutPlan workoutPlan, NutritionPlan nutritionPlan, ArrayList<Booking> bookings,
            ArrayList<Payment> payments, Calendar joinDate) {

        super(id, name, age, email, username, password, gender);
        this.fitnessGoal = fitnessGoal;
        this.trainingLevel = trainingLevel;
        this.dateOfBirth = dateOfBirth; 
        this.membershipPlan = membershipPlan;
        this.attendanceRecord = attendanceRecord;
        this.locker = locker;
        this.healthInfo = healthInfo;
        this.gymClasses = gymClasses;
        this.workoutPlan = workoutPlan;
        this.nutritionPlan = nutritionPlan;
        this.bookings = bookings;
        this.payments = payments;
        this.joinDate = joinDate;
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

    public ArrayList<GymClass> getGymClasses() {
        return gymClasses;
    }

    public void setGymClasses(ArrayList<GymClass> gymClasses) {
        this.gymClasses = gymClasses;
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

    public Calendar getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Calendar joinDate) {
        this.joinDate = joinDate;
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

    public void manageClass(GymClass gymClass) {
        //add or delete the class
        gymClass.manageClass(this);

    }

    public void manageMemberProfile() {

    }

    public void viewAllEnrolledClasses() {

        //for each gymclass in the arraylist, call the view fn
        for (GymClass gc : gymClasses) {
            gc.viewClassDetails();
        }

    }

    public String getMemprogress() {
        return memprogress;
    }

    @Override
    public String TrackmemProgress(int memID) throws RemoteException {
        String p = this.getMemprogress();
        return p;
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

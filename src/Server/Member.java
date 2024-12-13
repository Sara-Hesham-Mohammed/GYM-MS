/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.util.ArrayList;

/**
 *
 * @author Sara
 */
public class Member extends User{
    private MembershipPlan membershipPlan;
    private int attendanceRecord;
    private Locker locker;
    private HealthInfo healthInfo;
    private GymClass gymClass;
    private WorkoutPlan workoutPlan;
    private NutritionPlan nutritionPlan;
    private ArrayList<Booking> bookings;
    private ArrayList<Payment> payments;

    public Member() {
        
        
    }

    
    //temporary code for constructor bc idk how it is done
    public Member(int id, String name, int age, String email, String username, String password, String gender,
    MembershipPlan membershipPlan, int attendanceRecord, Locker locker, HealthInfo healthInfo,
    GymClass gymClass, WorkoutPlan workoutPlan, NutritionPlan nutritionPlan, ArrayList<Booking> bookings, 
    ArrayList<Payment> payments) {
        
        super(id,  name,  age,  email,  username,  password,  gender);
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
    
    
    
    
    
    
}

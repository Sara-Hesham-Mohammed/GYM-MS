package Server;

import java.util.ArrayList;

/**
 *
 * @author Sara
 */
public class Member extends User implements Observer , ROIMember {
    private String name;
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

    public Member(MembershipPlan membershipPlan, int attendanceRecord, Locker locker, HealthInfo healthInfo, GymClass gymClass, WorkoutPlan workoutPlan, NutritionPlan nutritionPlan, ArrayList<Booking> bookings, ArrayList<Payment> payments) {
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
    
    public String getName() {
        return name;
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

    // Implementation of Observer interface
    @Override
    public void update() {
        // Handle the received notification
        System.out.println("GYM Class Updated " );
        // Optionally, you can add logic to update the member's state or display the message in the GUI
    }
    
    // Implementation of ROIMember interface
    @Override
    public String viewMemberProfile() {
        return "Membership Plan: " + membershipPlan + ", Attendance: " + attendanceRecord + ", Locker Info: " + locker;
    }

    @Override
    public String viewHealthInfo() {
        return healthInfo != null ? healthInfo.toString() : "No health info available.";
    }
}




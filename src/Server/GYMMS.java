package Server;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Sara
 */
public class GYMMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Database db = new Database();

        MembershipPlan membershipPlan = new MembershipPlan(); // placeholder
        Locker lockerY = new Locker(); // placeholder
        HealthInfo healthInfoY = new HealthInfo(); // placeholder
        GymClass gymClassY = new GymClass(); // placeholder
        WorkoutPlan workoutPlanY = new WorkoutPlan(); // placeholder
        NutritionPlan nutritionPlanY = new NutritionPlan(); // placeholder
        ArrayList<Booking> bookingsY = new ArrayList<>(); // placeholder
        ArrayList<Payment> paymentsY = new ArrayList<>(); // placeholder
        Calendar joinDate = Calendar.getInstance();
        
        
        Member maddy = new Member(
                4, // id
                "maddy Adel", // name
                32, // age
                "maddy@gmail.com", // email
                "maddy", // username
                "password456", // password
                "female", // gender
                membershipPlan, // membership plan
                10, // attendance record (example value)
                lockerY, // locker
                healthInfoY, // health info
                gymClassY, // gym class
                workoutPlanY, // workout plan
                nutritionPlanY, // nutrition plan
                bookingsY, // bookings
                paymentsY,
                joinDate
        );

        // Setting start and end dates using Calendar
        membershipPlan.setStartDate(2024, 8, 16);
        membershipPlan.setEndDate(2025, 11, 14);
        membershipPlan.setPaid(false);
        membershipPlan.setDuration(3);

        membershipPlan.changeStatus(maddy);

        System.out.println(membershipPlan);
        db.insertMember(maddy);
        // Update membership plan in database
        //db.updateMembershipPlan(1, membershipPlan);
    }

}

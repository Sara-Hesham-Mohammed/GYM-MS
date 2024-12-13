/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Server;

import java.util.ArrayList;

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

        // Example objects for required classes
        MembershipPlan membershipPlan = new MembershipPlan(); // placeholder, adjust as needed
        Locker locker = new Locker(); // placeholder, adjust as needed
        HealthInfo healthInfo = new HealthInfo(); // placeholder, adjust as needed
        GymClass gymClass = new GymClass(); // placeholder, adjust as needed
        WorkoutPlan workoutPlan = new WorkoutPlan(); // placeholder, adjust as needed
        NutritionPlan nutritionPlan = new NutritionPlan(); // placeholder, adjust as needed
        ArrayList<Booking> bookings = new ArrayList<>(); // placeholder, adjust as needed
        ArrayList<Payment> payments = new ArrayList<>(); // placeholder, adjust as needed

// Member initialization
        Member mariam = new Member(
                1, // id
                "Mariam Karim", // name
                26, // age
                "MariamK80@yahoo.com", // email
                "MariamK80", // username
                "password123", // password (you can use a real password in practice)
                "Female", // gender
                membershipPlan, // membership plan
                5, // attendance record (example value)
                locker, // locker
                healthInfo, // health info
                gymClass, // gym class
                workoutPlan, // workout plan
                nutritionPlan, // nutrition plan
                bookings, // bookings
                payments // payments
        );

        MembershipPlan membershipPlanY = new MembershipPlan(); // placeholder
        Locker lockerY = new Locker(); // placeholder
        HealthInfo healthInfoY = new HealthInfo(); // placeholder
        GymClass gymClassY = new GymClass(); // placeholder
        WorkoutPlan workoutPlanY = new WorkoutPlan(); // placeholder
        NutritionPlan nutritionPlanY = new NutritionPlan(); // placeholder
        ArrayList<Booking> bookingsY = new ArrayList<>(); // placeholder
        ArrayList<Payment> paymentsY = new ArrayList<>(); // placeholder

// Member initialization
        Member youssef = new Member(
                2, // id
                "Youssef Adel", // name
                32, // age
                "AdelY1@gmail.com", // email
                "YoussefA32", // username
                "password456", // password
                "Male", // gender
                membershipPlanY, // membership plan
                10, // attendance record (example value)
                lockerY, // locker
                healthInfoY, // health info
                gymClassY, // gym class
                workoutPlanY, // workout plan
                nutritionPlanY, // nutrition plan
                bookingsY, // bookings
                paymentsY // payments
        );

        //Insert Question 1
        db.insertMember(mariam);
        db.insertMember(youssef);
        
        
        //Update Question 2
        Member s = db.getMemberByMail("AdelY1@gmail.com");       
        db.updateMember(s);

        
        
        //Update2 Question 3
        db.updateMemberEmail("Mairam Karim", "MariamKarim50@yahoo.com");
       
        //Retrieve Question 4
        ArrayList<Member> member = db.getMemberbyAge(26);

        for (int i = 0; i < member.size(); i++) {
            System.out.println(member.get(i).toString());
        }
       
       //Delete Question 5
        db.deleteMember("Youssef Adel");
    }

}

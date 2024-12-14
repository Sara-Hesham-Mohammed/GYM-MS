package Server;

import java.time.LocalDateTime;

public class GYMMS {
    public static void main(String[] args) {
        // Create Database instance
        Database db = new Database();
        db.initializeDatabase(); // Ensure all collections are created

        // Create Admin instance
        //Admin admin = new Admin();
           Admin admin = Admin.getAdminInstance();
        // Create Member observers
        Member member1 = new Member();
        member1.setMemberID(1);
        member1.setFitnessGoal("Lose Weight");
        member1.setTrainingLevel(2);

        Member member2 = new Member();
        member2.setMemberID(2);
        member2.setFitnessGoal("Build Muscle");
        member2.setTrainingLevel(3);
// Create Trainer observers
        Trainer trainer1 = new Trainer("Yoga", member1, null); // Trainer 1
        Trainer trainer2 = new Trainer("Bodybuilding", member2, null); // Trainer 2

        // Create Nutritionist observer
        Nutritionist nutritionist = new Nutritionist();
        // Register members as observers
       admin.registerObserver(member1);
        admin.registerObserver(member2);
        admin.registerObserver(trainer1);
        admin.registerObserver(trainer2);
        admin.registerObserver(nutritionist);

        // Create a GymClass object
        GymClass yogaClass = new GymClass(1, "Yoga Class", "John Doe",
                                          LocalDateTime.of(2024, 12, 20, 10, 0),
                                          LocalDateTime.of(2024, 12, 20, 11, 0), "1 hour");

        // Assign the GymClass object to the Admin
        admin.setClassName(yogaClass);  // This should be fine now

        // Update the GymClass to a new one
        GymClass advancedYogaClass = new GymClass(2, "Advanced Yoga", "Jane Doe",
                                                  LocalDateTime.of(2024, 12, 21, 10, 0),
                                                  LocalDateTime.of(2024, 12, 21, 11, 0), "1 hour");
        admin.setClassName(advancedYogaClass); // Notify members about the class update

        // Test member-specific functionality
        System.out.println("\nMember 1:");
        System.out.println("Fitness Goal: " + member1.getFitnessGoal());
        System.out.println("Training Level: " + member1.getTrainingLevel());

        System.out.println("\nMember 2:");
        System.out.println("Fitness Goal: " + member2.getFitnessGoal());
        System.out.println("Training Level: " + member2.getTrainingLevel());

        // Request Nutrition Plan for a member
        member1.requestNutritionPlan();
        db.requestNutritionPlan(member1); // Ensure it is saved in the database
        
        
        
        // Create Facility objects (updated based on your class)
        Facility yogaRoom = new Facility(1, "Yoga Room", "08:00 AM", "09:00 AM", 30.0f, 20, "Yoga sessions");
        Facility gym = new Facility(2, "Gym", "06:00 AM", "08:00 PM", 50.0f, 50, "General gym use");

        // Create Reservation object
        Reservation reservation1 = new Reservation(101, 5, yogaRoom);  // 5 seats for Yoga Room
        Reservation reservation2 = new Reservation(102, 10, gym);      // 10 seats for Gym

        // Test Facility Reservation for Member 1:
        System.out.println("\nTesting Facility Reservation for Member 1:");

        // Attempt to make reservation for Yoga Room
        if (reservation1.makeReservation(member1)) {
            System.out.println("Yoga Room successfully booked for " + reservation1.getNoOfReservedSeats() + " seats.");
        } else {
            System.out.println("Yoga Room is unavailable for the requested number of seats.");
        }

        // Attempt to make reservation for Gym
        if (reservation2.makeReservation(member1)) {
            System.out.println("Gym successfully booked for " + reservation2.getNoOfReservedSeats() + " seats.");
        } else {
            System.out.println("Gym is unavailable for the requested number of seats.");
        }

        // Confirm booking in the database (simulate the database saving)
        db.bookFacility(member1, yogaRoom,5);  // Confirm yoga room booking in database
        db.bookFacility(member1, gym,5);       // Confirm gym booking in database
    
    }
}




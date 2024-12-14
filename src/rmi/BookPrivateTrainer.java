/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

/**
 *
 * @author DELL
 */
import java.util.ArrayList;
import java.util.Scanner;

public class BookPrivateTrainer implements BookingBehavior {
    private String trainer;
    private ArrayList<String> availableTrainers;

    // Constructor to initialize available trainers
    public BookPrivateTrainer () {
        this.availableTrainers = new ArrayList<>();
        this.availableTrainers.add("John - Strength Training Specialist");
        this.availableTrainers.add("Sarah - Yoga and Flexibility Expert");
        this.availableTrainers.add("Mike - Cardio and Endurance Coach");
        this.availableTrainers.add("Emily - Weight Loss and Nutrition Advisor");
    }

    // Method to display available trainers
    public void displayAvailableTrainers() {
        System.out.println("Available Private Trainers:");
        for (int i = 0; i < availableTrainers.size(); i++) {
            System.out.println((i + 1) + ". " + availableTrainers.get(i));
        }
    }

    // Method to select a trainer
    public void selectTrainer() {
        displayAvailableTrainers();
        System.out.print("Please select a trainer by entering the corresponding number: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= availableTrainers.size()) {
            this.trainer = availableTrainers.get(choice - 1);
            System.out.println("You have selected: " + trainer);
        } else {
            System.out.println("Invalid selection. No trainer booked.");
            this.trainer = null; // Reset selection if invalid
        }
    }

    @Override
    public void makeBooking(int userId) {
        if (trainer != null) {
            System.out.println("User " + userId + " has successfully booked the private trainer: " + trainer);
        } else {
            System.out.println("No trainer selected. Booking failed.");
        }
    }
}


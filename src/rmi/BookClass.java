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

public class BookClass implements BookingBehavior {
    private String gymClass;
    private ArrayList<String> availableClasses;

    // Constructor to initialize available classes
    public BookClass() {
        this.availableClasses = new ArrayList<>();
        this.availableClasses.add("Yoga Class");
        this.availableClasses.add("Pilates Class");
        this.availableClasses.add("Spinning Class");
        this.availableClasses.add("Zumba Class");
    }

    // Method to display available classes
    public void displayAvailableClasses() {
        System.out.println("Available Gym Classes:");
        for (int i = 0; i < availableClasses.size(); i++) {
            System.out.println((i + 1) + ". " + availableClasses.get(i));
        }
    }

    // Method to select a class
    public void selectClass() {
        displayAvailableClasses();
        System.out.print("Please select a class by entering the corresponding number: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= availableClasses.size()) {
            this.gymClass = availableClasses.get(choice - 1);
            System.out.println("You have selected: " + gymClass);
        } else {
            System.out.println("Invalid selection. No class booked.");
            this.gymClass = null; // Reset selection if invalid
        }
    }

    @Override
    public void makeBooking(int userId) {
        if (gymClass != null) {
            System.out.println("User " + userId + " has successfully booked the gym class: " + gymClass);
        } else {
            System.out.println("No class selected. Booking failed.");
        }
    }
}


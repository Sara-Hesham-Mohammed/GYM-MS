/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

/**
 *
 * @author DELL
 */
import java.util.ArrayList;
import java.util.Scanner;

public class BookFacility implements BookingBehavior {
    private String facility; 
    private ArrayList<String> availableFacilities;

    // Constructor to initialize available facilities
    public BookFacility() {
        this.availableFacilities = new ArrayList<>();
        this.availableFacilities.add("Swimming Pool");
        this.availableFacilities.add("Tennis Court");
        this.availableFacilities.add("Sauna");
        this.availableFacilities.add("Squash Court");
    }

    // Method to display available facilities
    public void displayAvailableFacilities() {
        System.out.println("Available Facilities:");
        for (int i = 0; i < availableFacilities.size(); i++) {
            System.out.println((i + 1) + ". " + availableFacilities.get(i));
        }
    }

    // Method to select a facility
    public void selectFacility() {
        displayAvailableFacilities();
        System.out.print("Please select a facility by entering the corresponding number: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= availableFacilities.size()) {
            this.facility = availableFacilities.get(choice - 1);
            System.out.println("You have selected: " + facility);
        } else {
            System.out.println("Invalid selection. No facility booked.");
            this.facility = null; // Reset selection if invalid
        }
    }

    @Override
    public void makeBooking(int userId) {
        if (facility != null) {
            System.out.println("User " + userId + " has successfully booked the facility: " + facility);
        } else {
            System.out.println("No facility selected. Booking failed.");
        }
    }
}


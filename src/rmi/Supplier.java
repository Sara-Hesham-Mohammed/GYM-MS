/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import java.util.ArrayList;

/**
 *
 * @author Sara
 */
public class Supplier extends User{
    private ArrayList<Equipment> equipment;

    public Supplier() {
    }

    public Supplier(ArrayList<Equipment> equipment) {
        this.equipment = equipment;
    }

    public ArrayList<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Equipment> equipment) {
        this.equipment = equipment;
    }
    
       // Method to process equipment request
    public void processRequest(Equipment equipmentRequest) {
        equipment.add(equipmentRequest);  // Add requested equipment to inventory
        System.out.println("Equipment " + equipmentRequest.getName() + " requested and added to inventory.");
    }
    
      public String handleMaintenanceRequest(Equipment equipmentRequest, String details) {
        // Check if necessary details are provided
        if (equipmentRequest == null || details == null || details.isEmpty()) {
            return "Maintenance request is missing required details. Please provide more information.";
        }

        // Log the maintenance request
        System.out.println("Processing maintenance for equipment: " + equipmentRequest.getName());
        System.out.println("Details: " + details);

        // Simulate scheduling maintenance
        equipmentRequest.setState("Under Maintenance");
        System.out.println("Scheduling maintenance for equipment: " + equipmentRequest.getName());

        // Simulate maintenance completion
        equipmentRequest.setState("Completed");
        System.out.println("Maintenance completed for equipment: " + equipmentRequest.getName());

        return "Maintenance request for equipment '" + equipmentRequest.getName() + "' processed successfully.";
    }
    
    
}

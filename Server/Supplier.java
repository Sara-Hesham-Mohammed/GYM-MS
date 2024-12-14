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
}
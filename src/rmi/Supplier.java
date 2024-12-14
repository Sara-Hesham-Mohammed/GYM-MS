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
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmi;

import java.util.ArrayList;

/**
 *
 * @author m
 */
public interface ReadOnlyFacility {

    public boolean checkAvailability(int noOfSeats);

    public void bookSeats(int facilityID, int noOfSeats);

    public void cancelBook(int noOfSeats);

    public int getFacilityID();

    /*public ArrayList<Facility> viewMyFacilities(int adminID);*/

    public ArrayList<Facility> viewMyFacilities(int MemberID);

}

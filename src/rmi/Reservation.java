/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

/**
 *
 * @author m
 */
public class Reservation {

    private int reservationID;
    private ReadOnlyFacility facility;
    private int noOfReservedSeats;
    private Payment pay;

    public Reservation() {
        facility = new Facility();
    }

    public Reservation(int reservationID, int noOfReservedSeats, ReadOnlyFacility facility) {
        this.reservationID = reservationID;
        this.facility = facility;
        this.noOfReservedSeats = noOfReservedSeats;
        this.pay = new Payment();
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public ReadOnlyFacility getFacility() {
        return facility;
    }

    public void setFacility(ReadOnlyFacility facility) {
        this.facility = facility;
    }

    public int getNoOfReservedSeats() {
        return noOfReservedSeats;
    }

    public void setNoOfReservedSeats(int noOfReservedSeats) {
        this.noOfReservedSeats = noOfReservedSeats;
    }

    public Payment getPay() {
        return pay;
    }

    public void setPay(Payment pay) {
        this.pay = pay;
    }

    public boolean makeReservation(Member m) {
    if (facility.checkAvailability(noOfReservedSeats)) {
        // Pass the facilityID and noOfReservedSeats to reserveFacility
        Database.getDatabase().reserveFacility(facility.getFacilityID(), noOfReservedSeats);
        // Book the seats
        facility.bookSeats(facility.getFacilityID(), noOfReservedSeats);
        return true;
    } else {
        return false;
    }
}


}

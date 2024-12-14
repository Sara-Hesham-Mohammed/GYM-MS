/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import java.util.Date;
import java.time.*;
import java.util.Calendar;

import java.util.ArrayList;

/**
 *
 * @author Sara
 */
public class Booking {

    private int bookingID;
    private int userID;
    private Calendar bookingDate;
    private Calendar startTime;
    private Calendar endTime;
    private BookingBehavior bookingType;
    private boolean paid;
    private Payment payment; // Payment instance

    public Booking() {
    }


    public Booking(int bookingID, int userID, Calendar bookingDate, Calendar startTime, Calendar endTime, BookingBehavior bookingType, boolean paid) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingType = bookingType;
        this.paid = paid;
        this.payment = new Payment(bookingID, bookingDate, 0); // Default amount = 0
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Calendar getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Calendar bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public BookingBehavior getBookingType() {
        return bookingType;
    }

    public void setBookingType(BookingBehavior bookingType) {
        this.bookingType = bookingType;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    
    
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
        // Method to set the payment type and execute payment
    public void setPaymentType(PaymentBehaviour paymentBehaviour, float amount) {
        payment.setPaymentMethod(paymentBehaviour);
        payment.makePayment();
    }


    public void performBooking(Booking booking, int id, ArrayList<Booking> bookings) {
        if (bookingType != null) {
            bookingType.makeBooking(id); // Perform the booking behavior logic
            bookings.add(booking); // Add the booking to the member's list
            System.out.println("Booking successfully added for member: " + id);
        } else {
            System.out.println("No booking behavior set.");
        }
    }

}

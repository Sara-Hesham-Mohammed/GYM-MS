/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.util.Date;
import java.time.*;

/**
 *
 * @author Sara
 */
public class Booking {
    
    private int bookingID;
    private int userID;
    private Date bookingDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BookingBehavior bookingType;
    private boolean paid;

    public Booking() {
    }

    public Booking(int bookingID, int userID, Date bookingDate, LocalDateTime startTime, LocalDateTime endTime, BookingBehavior bookingType, boolean paid) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingType = bookingType;
        this.paid = paid;
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

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
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
    
    
}
